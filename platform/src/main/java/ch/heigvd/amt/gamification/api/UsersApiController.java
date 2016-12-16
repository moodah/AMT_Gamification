package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.User;

import java.math.BigDecimal;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-16T15:16:07.537Z")

@Controller
public class UsersApiController implements UsersApi {

    public ResponseEntity<List<User>> usersGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization,
        @ApiParam(value = "The page number", defaultValue = "1") @RequestParam(value = "page", required = false, defaultValue="1") BigDecimal page,
        @ApiParam(value = "Number of result per page", defaultValue = "10") @RequestParam(value = "perPage", required = false, defaultValue="10") BigDecimal perPage) {
        // do some magic!
        return new ResponseEntity<List<User>>(HttpStatus.OK);
    }

    public ResponseEntity<User> usersIdGet(@ApiParam(value = "The user's ID",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<User>(HttpStatus.OK);
    }

}
