package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dao.ApplicationDao;
import ch.heigvd.amt.gamification.model.Token;
import ch.heigvd.amt.gamification.model.Application;
import java.math.BigDecimal;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-13T18:36:02.067Z")

@RestController
public class ApplicationsApiController implements ApplicationsApi {

    @Autowired
    private ApplicationDao applicationDao;

    public ResponseEntity<Token> applicationsAuthPost(@ApiParam(value = "The application informations" ,required=true ) @RequestBody Application application) {
        // do some magic!
        return new ResponseEntity<Token>(HttpStatus.OK);
    }

    public ResponseEntity<Void> applicationsIdDelete(@ApiParam(value = "ID of the application",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
            applicationDao.delete(id.longValue());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<String> applicationsPost(@ApiParam(value = "The application informations" ,required=true ) @RequestBody Application application) {
        // do some magic!
        try {
            Application app = new Application(application.getName(), application.getPassword());
            if (applicationDao.findByName(app.getName()) == null) {
                applicationDao.save(app);
                return new ResponseEntity<String>(HttpStatus.CREATED);
            } else {
                // Already exists
                return new ResponseEntity<String>("This application name is already registered", HttpStatus.CONFLICT);
            }
        }
        catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
        }
    }

}
