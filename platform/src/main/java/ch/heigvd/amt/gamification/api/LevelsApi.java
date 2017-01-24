package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dto.LevelCreationDTO;
import ch.heigvd.amt.gamification.dto.LevelPresentationDTO;
import ch.heigvd.amt.gamification.errors.ErrorMessageGenerator;
import ch.heigvd.amt.gamification.model.Level;
import java.math.BigDecimal;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Api(value = "levels", description = "the levels API")
public interface LevelsApi {

    @ApiOperation(value = "Delete all levels", notes = "Delete all levels for this application", response = Void.class, tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class),
            @ApiResponse(code = 400, message = "Error payload", response = ErrorMessageGenerator.class) })
    @RequestMapping(value = "/levels",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> levelsDelete(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Get Gamification levels", notes = "The levels endpoint returns the levels defined by the client", response = LevelPresentationDTO.class, responseContainer = "List", tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "An array of levels", response = LevelPresentationDTO.class )})
    @RequestMapping(value = "/levels",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<ArrayList<LevelPresentationDTO>> levelsGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Delete the level with {id}", notes = "Delete the level with {id}", response = Void.class, tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class),
            @ApiResponse(code = 400, message = "Error payload", response = ErrorMessageGenerator.class) })
    @RequestMapping(value = "/levels/{id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> levelsIdDelete(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Get level with this {id}", notes = "Get level with this {id}", response = LevelPresentationDTO.class, tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requested level", response = LevelPresentationDTO.class) })
    @RequestMapping(value = "/levels/{id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<LevelPresentationDTO> levelsIdGet(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                         @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Update the level with {id}", notes = "Update the level with {id}", response = String.class, tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Updated level", response = LevelPresentationDTO.class),
            @ApiResponse(code = 409, message = "Level already exists", response = ErrorMessageGenerator.class)})
    @RequestMapping(value = "/levels/{id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PATCH)
    ResponseEntity<LevelPresentationDTO> levelsIdPatch(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                           @ApiParam(value = "", required=false) @RequestBody LevelCreationDTO level,
                                           @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Create Gamification levels", notes = "The levels endpoint allows the client to submit new levels", response = String.class, tags={ "Levels", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Newly created level's URIs", response = String.class),
            @ApiResponse(code = 400, message = "Error payload", response = ErrorMessageGenerator.class) })
    @RequestMapping(value = "/levels",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ArrayList<String>> levelsPost(@ApiParam(value = "" ,required=true ) @RequestBody List<LevelCreationDTO> levels,
                                     @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);

}