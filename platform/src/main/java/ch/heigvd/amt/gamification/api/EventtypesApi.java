package ch.heigvd.amt.gamification.api;

import java.math.BigDecimal;

import ch.heigvd.amt.gamification.dto.EventtypeCreationDTO;
import ch.heigvd.amt.gamification.model.Eventtype;
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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-01-24T12:55:51.106Z")

@Api(value = "eventtypes", description = "the eventtypes API")
public interface EventtypesApi {

    @ApiOperation(value = "Get a list of eventtypes", notes = "", response = Eventtype.class, responseContainer = "List", tags = {"Eventtypes",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of eventtypes", response = Eventtype.class)})
    @RequestMapping(value = "/eventtypes",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Eventtype>> eventtypesGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Delete eventtype with specified id", notes = "", response = Void.class, tags = {"Eventtypes",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class)})
    @RequestMapping(value = "/eventtypes/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> eventtypesIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                            @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Get eventtype with specified id", notes = "", response = Eventtype.class, tags = {"Eventtypes",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requested eventtype", response = Eventtype.class)})
    @RequestMapping(value = "/eventtypes/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Eventtype> eventtypesIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                              @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Update eventtype with specified id", notes = "", response = Eventtype.class, tags = {"Eventtypes",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Eventtype updated", response = Eventtype.class)})
    @RequestMapping(value = "/eventtypes/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PATCH)
    ResponseEntity<Eventtype> eventtypesIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                @ApiParam(value = "Updated eventtype", required = true) @RequestBody EventtypeCreationDTO eventtype);


    @ApiOperation(value = "Create a new eventtype", notes = "", response = Eventtype.class, tags = {"Eventtypes",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Eventtype created", response = Eventtype.class)})
    @RequestMapping(value = "/eventtypes",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Eventtype> eventtypesPost(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                             @ApiParam(value = "New eventtype", required = true) @RequestBody EventtypeCreationDTO eventtype);

}
