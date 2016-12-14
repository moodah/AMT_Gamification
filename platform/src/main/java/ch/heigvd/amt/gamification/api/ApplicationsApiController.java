package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.Error;
import ch.heigvd.amt.gamification.model.Token;
import ch.heigvd.amt.gamification.model.Application;
import java.math.BigDecimal;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-13T18:36:02.067Z")

@RestController
public class ApplicationsApiController implements ApplicationsApi {

    public ResponseEntity<Token> applicationsAuthPost(@ApiParam(value = "The application informations" ,required=true ) @RequestBody Application application) {
        // do some magic!
        return new ResponseEntity<Token>(HttpStatus.OK);
    }

    public ResponseEntity<Void> applicationsIdDelete(@ApiParam(value = "ID of the application",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> applicationsPost(@ApiParam(value = "The application informations" ,required=true ) @RequestBody Application application) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
