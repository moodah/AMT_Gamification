package ch.heigvd.amt.gamification.api;

import java.math.BigDecimal;

import ch.heigvd.amt.gamification.dto.AchievementCreationDTO;
import ch.heigvd.amt.gamification.dto.AchievementPresentationDTO;
import ch.heigvd.amt.gamification.model.Achievement;
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

@Api(value = "achievements", description = "the achievements API")
public interface AchievementsApi {

    @ApiOperation(value = "Get a list of achievements for this application", notes = "", response = Achievement.class, responseContainer = "List", tags = {"Achievements",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of achievements", response = Achievement.class)})
    @RequestMapping(value = "/achievements",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<AchievementPresentationDTO>> achievementsGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Delete achievement with specified id", notes = "", response = Void.class, tags = {"Achievements",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class)})
    @RequestMapping(value = "/achievements/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> achievementsIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                              @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Get achievement with specified id", notes = "", response = Achievement.class, tags = {"Achievements",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requested achievement", response = Achievement.class)})
    @RequestMapping(value = "/achievements/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<AchievementPresentationDTO> achievementsIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                  @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Update achievement with specified", notes = "", response = Achievement.class, tags = {"Achievements",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Achievement updated", response = Achievement.class)})
    @RequestMapping(value = "/achievements/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PATCH)
    ResponseEntity<AchievementPresentationDTO> achievementsIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                    @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                    @ApiParam(value = "Updated achievement", required = true) @RequestBody AchievementCreationDTO newAchievement);


    @ApiOperation(value = "Create a new achievement", notes = "", response = Achievement.class, tags = {"Achievements",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Achievement created", response = Achievement.class)})
    @RequestMapping(value = "/achievements",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<AchievementPresentationDTO> achievementsPost(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                 @ApiParam(value = "New achievement", required = true) @RequestBody AchievementCreationDTO achievement);

    @ApiOperation(value = "Delete all achievements of applications", notes = "", response = Void.class, tags = {"Achievements",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class)})
    @RequestMapping(value = "/achievements",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> achievementsDelete(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);

}
