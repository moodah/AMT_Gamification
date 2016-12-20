package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.Level;
import java.math.BigDecimal;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Api(value = "levels", description = "the levels API")
public interface LevelsApi {

    @ApiOperation(value = "Delete all levels", notes = "Delete all levels for this application", response = Void.class, tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class),
            @ApiResponse(code = 200, message = "Error payload", response = Void.class) })
    @RequestMapping(value = "/levels",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> levelsDelete(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Get Gamification levels", notes = "The levels endpoint returns the levels defined by the client", response = Level.class, responseContainer = "List", tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "An array of levels", response = Level.class),
            @ApiResponse(code = 200, message = "Error payload", response = Level.class) })
    @RequestMapping(value = "/levels",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Level>> levelsGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Delete the level with {id}", notes = "Delete the level with {id}", response = Void.class, tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class),
            @ApiResponse(code = 200, message = "Error payload", response = Void.class) })
    @RequestMapping(value = "/levels/{id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> levelsIdDelete(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Get level with this {id}", notes = "Get level with this {id}", response = Level.class, tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requested level", response = Level.class),
            @ApiResponse(code = 200, message = "Error payload", response = Level.class) })
    @RequestMapping(value = "/levels/{id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Level> levelsIdGet(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                      @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Update the level with {id}", notes = "Update the level with {id}", response = Level.class, tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Updated level", response = Level.class),
            @ApiResponse(code = 200, message = "Error payload", response = Level.class) })
    @RequestMapping(value = "/levels/{id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PATCH)
    ResponseEntity<Level> levelsIdPatch(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                        @ApiParam(value = "", required=false) @RequestBody Level level,
                                        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Create Gamification levels", notes = "The levels endpoint allows the client to submit new levels", response = Level.class, tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Newly created level", response = Level.class),
            @ApiResponse(code = 200, message = "Error payload", response = Level.class) })
    @RequestMapping(value = "/levels",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<List<String>> levelsPost(@ApiParam(value = "" ,required=true ) @RequestBody List<Level> levels,
                                     @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);

}