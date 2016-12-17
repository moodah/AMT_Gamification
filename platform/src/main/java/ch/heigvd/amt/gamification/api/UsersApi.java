package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.User;

import java.math.BigDecimal;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-16T15:16:07.537Z")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "Get a list of all users", notes = "The Users endpoint returns the reputation of the number of users passed in parameter", response = User.class, responseContainer = "List", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Requested user reputation", response = User.class),
        @ApiResponse(code = 200, message = "HttpErrorResponse payload", response = User.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<User>> usersGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization,
        @ApiParam(value = "The page number", defaultValue = "1") @RequestParam(value = "page", required = false, defaultValue="1") BigDecimal page,
        @ApiParam(value = "Number of result per page", defaultValue = "10") @RequestParam(value = "perPage", required = false, defaultValue="10") BigDecimal perPage);


    @ApiOperation(value = "Get a user's reputation", notes = "The Users endpoint returns the reputation of the user defined by the parameter {id}", response = User.class, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Requested user reputation", response = User.class),
        @ApiResponse(code = 200, message = "HttpErrorResponse payload", response = User.class) })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<User> usersIdGet(@ApiParam(value = "The user's ID",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);

}
