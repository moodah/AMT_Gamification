package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.Error;
import ch.heigvd.amt.gamification.model.Reputation;
import java.math.BigDecimal;
import ch.heigvd.amt.gamification.model.Username;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-13T18:36:02.067Z")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "Delete all users", notes = "Delete all users", response = Void.class, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class),
        @ApiResponse(code = 200, message = "Error payload", response = Void.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> usersDelete(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Get a list of all users", notes = "The Users endpoint returns the reputation of the number of users passed in parameter", response = Reputation.class, responseContainer = "List", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Requested user reputation", response = Reputation.class),
        @ApiResponse(code = 200, message = "Error payload", response = Reputation.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Reputation>> usersGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization,
        @ApiParam(value = "The page number", defaultValue = "1") @RequestParam(value = "page", required = false, defaultValue="1") BigDecimal page,
        @ApiParam(value = "Number of result per page", defaultValue = "10") @RequestParam(value = "perPage", required = false, defaultValue="10") BigDecimal perPage);


    @ApiOperation(value = "Get a user's reputation", notes = "The Users endpoint returns the reputation of the user defined by the parameter {id}", response = Reputation.class, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Requested user reputation", response = Reputation.class),
        @ApiResponse(code = 200, message = "Error payload", response = Reputation.class) })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Reputation> usersIdGet(@ApiParam(value = "The user's ID",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Create a new user", notes = "Create a new user", response = Username.class, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Newly created user", response = Username.class),
        @ApiResponse(code = 200, message = "Error payload", response = Username.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Username> usersPost(@ApiParam(value = "The new user" ,required=true ) @RequestBody Username username,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);

}
