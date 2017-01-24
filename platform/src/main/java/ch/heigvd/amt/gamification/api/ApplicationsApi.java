package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Token;
import ch.heigvd.amt.gamification.dto.ApplicationDTO;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Api(value = "applications", description = "the applications API")
public interface ApplicationsApi {

    @ApiOperation(value = "Get the application's token", notes = "", response = Token.class, tags = {"Applications", "Authentication",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Application token", response = Token.class)})
    @RequestMapping(value = "/applications/auth",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Token> applicationsAuthPost(@ApiParam(value = "Requested application", required = true) @RequestBody ApplicationDTO application);


    @ApiOperation(value = "Delete application with specified id", notes = "", response = Void.class, tags = {"Applications",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class)})
    @RequestMapping(value = "/applications/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> applicationsDelete(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Create a new application", notes = "", response = Application.class, tags = {"Applications",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Application created", response = Application.class)})
    @RequestMapping(value = "/applications",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Application> applicationsPost(@ApiParam(value = "New application", required = true) @RequestBody ApplicationDTO application);

    @ApiOperation(value = "Delete application with specified id", notes = "", response = Void.class, tags = {"Applications",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class)})
    @RequestMapping(value = "/applications/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> applicationsIdDelete(@ApiParam(value = "The applications's ID", required = true) @PathVariable("id") BigDecimal id,
                                              @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Get application with specified id", notes = "", response = Application.class, tags = {"Applications",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requested application", response = Application.class)})
    @RequestMapping(value = "/applications/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Application> applicationsIdGet(@ApiParam(value = "The applications's id", required = true) @PathVariable("id") BigDecimal id,
                                                  @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Patch application with specified id", notes = "", response = Application.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Application updated", response = Application.class)})
    @RequestMapping(value = "/applications/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PATCH)
    ResponseEntity<Application> applicationsIdPatch(@ApiParam(value = "The applications's ID", required = true) @PathVariable("id") BigDecimal id,
                                                    @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                    @ApiParam(value = "Updated application", required = true) @RequestBody ApplicationDTO application);

}
