package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.Error;
import ch.heigvd.amt.gamification.model.Token;
import ch.heigvd.amt.gamification.model.Application;
import java.math.BigDecimal;

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

@Api(value = "applications", description = "the applications API")
public interface ApplicationsApi {

    @ApiOperation(value = "Get the application token", notes = "The Applications/Auth endpoint returns the application token", response = Token.class, tags={ "Applications", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Application token", response = Token.class),
        @ApiResponse(code = 200, message = "Error payload", response = Token.class) })
    @RequestMapping(value = "/applications/auth",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Token> applicationsAuthPost(@ApiParam(value = "The application informations" ,required=true ) @RequestBody Application application);


    @ApiOperation(value = "Delete an application", notes = "Delete the application with specified {id}", response = Void.class, tags={ "Applications", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class),
        @ApiResponse(code = 200, message = "Error payload", response = Void.class) })
    @RequestMapping(value = "/applications/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> applicationsIdDelete(@ApiParam(value = "ID of the application",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Register a new application", notes = "The Applications endpoint allows to register a new application on the platform", response = Void.class, tags={ "Applications", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Application created", response = Void.class),
        @ApiResponse(code = 200, message = "Error payload", response = Void.class) })
    @RequestMapping(value = "/applications",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> applicationsPost(@ApiParam(value = "The application informations" ,required=true ) @RequestBody Application application);

}
