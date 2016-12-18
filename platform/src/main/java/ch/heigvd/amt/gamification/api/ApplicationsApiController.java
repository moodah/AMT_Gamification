package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.annotations.Authenticate;
import ch.heigvd.amt.gamification.configuration.AppConfig;
import ch.heigvd.amt.gamification.dao.ApplicationDao;
import ch.heigvd.amt.gamification.security.Authentication;
import ch.heigvd.amt.gamification.model.HttpStatusException;
import ch.heigvd.amt.gamification.model.Token;
import ch.heigvd.amt.gamification.model.Application;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@RestController
public class ApplicationsApiController implements ApplicationsApi {

    @Autowired
    private ApplicationDao applicationDao;

    public ResponseEntity<Token> applicationsAuthPost(@ApiParam(value = "The application informations" ,required=true ) @RequestBody Application application) {

        dataValidation(application);

        Application persistentApp = applicationDao.findByName(application.getName());

        if (persistentApp != null) {
            if (!persistentApp.getPassword().equals(application.getPassword())) {
                throw new HttpStatusException(HttpStatus.FORBIDDEN,
                        "Wrong password for application '" + application.getName() + "'");
            }
        } else {
            throw new HttpStatusException(HttpStatus.CONFLICT,
                    "Application '" + application.getName() + "' does not exist.");
        }

        Token token = Authentication.generateToken(persistentApp);

        return new ResponseEntity<Token>(token, HttpStatus.CREATED);
    }

    @Authenticate
    public ResponseEntity<Void> applicationsDelete(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        long appId = Authentication.getId(authorization);
        applicationDao.delete(appId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> applicationsPost(@ApiParam(value = "The application informations" ,required=true ) @RequestBody Application application) {
        // register a new application
        dataValidation(application);

        if (applicationDao.findByName(application.getName()) != null)
            throw new HttpStatusException(HttpStatus.CONFLICT,
                    "Application '" + application.getName() + "' already exists.");

        System.out.println("save(app) return: " + applicationDao.save(application));

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    private void dataValidation(Application application) {
        String appName = application.getName();
        String appPass = application.getPassword();

        if (appName == null)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "The application's name is not specified.");

        if (appPass == null)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "The application's password is not specified.");

        if (appName.length() < AppConfig.MIN_APP_NAME_LENGTH || appName == null)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST,
                    "Application name must be at least " + AppConfig.MIN_APP_NAME_LENGTH + " characters long.");

        if (appPass.length() < AppConfig.MIN_APP_PWD_LENGTH)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST,
                    "Application password must be at least " + AppConfig.MIN_APP_PWD_LENGTH + " characters long.");
    }

}

