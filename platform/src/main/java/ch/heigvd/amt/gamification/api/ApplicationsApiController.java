package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.annotations.Authenticate;
import ch.heigvd.amt.gamification.configuration.AppConfig;
import ch.heigvd.amt.gamification.dao.ApplicationDao;
import ch.heigvd.amt.gamification.dto.ApplicationCreationDTO;
import ch.heigvd.amt.gamification.dto.ApplicationPresentationDTO;
import ch.heigvd.amt.gamification.errors.ErrorMessageGenerator;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.security.Authentication;
import ch.heigvd.amt.gamification.errors.HttpStatusException;
import ch.heigvd.amt.gamification.model.Token;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@RestController
public class ApplicationsApiController implements ApplicationsApi {

    @Autowired
    private ApplicationDao applicationDao;

    public ResponseEntity<Token> applicationsAuthPost(@ApiParam(value = "The application informations", required = true) @RequestBody ApplicationCreationDTO application) {

        dataValidation(application);

        Application persistentApp = applicationDao.findByName(application.getName());

        if (persistentApp != null) {

            String pass = get_SHA_512_SecurePassword(application.getPassword(), AppConfig.SALT);

            System.out.println(pass + " AND " + persistentApp.getPassword());

            if (!persistentApp.getPassword().equals(pass)) {
                throw new HttpStatusException(HttpStatus.NOT_FOUND,
                        ErrorMessageGenerator.notFoundByField("application named " + application.getName(), "password", application.getPassword()));
            }
        } else {
            throw new HttpStatusException(HttpStatus.NOT_FOUND,
                    ErrorMessageGenerator.notFoundByName("Application", application.getName()));
        }

        Token token = Authentication.generateToken(persistentApp);

        return new ResponseEntity<Token>(token, HttpStatus.CREATED);
    }

    @Authenticate
    public ResponseEntity<Void> applicationsDelete(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);

        applicationDao.delete(appId);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<ApplicationPresentationDTO> applicationsPost(@ApiParam(value = "The application informations", required = true) @RequestBody ApplicationCreationDTO application) {
        // register a new application
        dataValidation(application);

        if (applicationDao.findByName(application.getName()) != null)
            throw new HttpStatusException(HttpStatus.CONFLICT,
                    ErrorMessageGenerator.nameAlreadyExists("Application", application.getName()));

        // Encrypt password
        Application persistentApp = new Application(application.getName());
        persistentApp.setPassword(get_SHA_512_SecurePassword(application.getPassword(), AppConfig.SALT));

        System.out.println("save(app) return: " + applicationDao.save(persistentApp));

        return new ResponseEntity<ApplicationPresentationDTO>(new ApplicationPresentationDTO(persistentApp), HttpStatus.CREATED);
    }

    private void dataValidation(ApplicationCreationDTO application) {
        String appName = application.getName();
        String appPass = application.getPassword();

        if (appName == null)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Application", "name"));

        if (appPass == null)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Application", "password"));

        if (appName.length() < AppConfig.MIN_APP_NAME_LENGTH || appName == null)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST,
                    ErrorMessageGenerator.fieldTooShort("Application", "name", AppConfig.MIN_APP_NAME_LENGTH));

        if (appPass.length() < AppConfig.MIN_APP_PWD_LENGTH)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST,
                    ErrorMessageGenerator.fieldTooShort("Application", "password", AppConfig.MIN_APP_PWD_LENGTH));
    }

    /**
     * Source: http://stackoverflow.com/questions/33085493/hash-a-password-with-sha-512-in-java
     *
     * @param passwordToHash
     * @param salt
     * @return the hashed password
     */
    public String get_SHA_512_SecurePassword(String passwordToHash, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance(AppConfig.ENCRYPTION_ALGORITHM);
            md.update(salt.getBytes(AppConfig.CHARSET));
            byte[] bytes = md.digest(passwordToHash.getBytes(AppConfig.CHARSET));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}

