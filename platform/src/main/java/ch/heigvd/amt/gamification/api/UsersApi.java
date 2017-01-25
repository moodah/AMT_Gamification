package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dto.UserPresentationDTO;

import java.math.BigDecimal;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "Get a list of all users of this application", notes = "", response = UserPresentationDTO.class, responseContainer = "List", tags = {"Users",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all users of this application", response = UserPresentationDTO.class)})
    @RequestMapping(value = "/users",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<UserPresentationDTO>> usersGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Get user with specified id", notes = "", response = UserPresentationDTO.class, tags = {"Users",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requested user", response = UserPresentationDTO.class)})
    @RequestMapping(value = "/users/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<UserPresentationDTO> usersIdGet(@ApiParam(value = "The user's ID", required = true) @PathVariable("id") BigDecimal id,
                                                           @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);
}
