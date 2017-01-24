package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dto.UserPresentationDTO;
import ch.heigvd.amt.gamification.model.User;

import java.math.BigDecimal;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "Get a list of all users of this application", notes = "", response = User.class, responseContainer = "List", tags = {"Users",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all users of this application", response = User.class)})
    @RequestMapping(value = "/users",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ArrayList<UserPresentationDTO>> usersGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                            @ApiParam(value = "The page number", defaultValue = "1") @RequestParam(value = "page", required = false, defaultValue = "1") BigDecimal page,
                                                            @ApiParam(value = "Number of result per page", defaultValue = "10") @RequestParam(value = "perPage", required = false, defaultValue = "10") BigDecimal perPage);


    @ApiOperation(value = "Get user with specified id", notes = "", response = User.class, tags = {"Users",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requested user", response = User.class)})
    @RequestMapping(value = "/users/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<UserPresentationDTO> usersIdGet(@ApiParam(value = "The user's ID", required = true) @PathVariable("id") BigDecimal id,
                                                   @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);
}
