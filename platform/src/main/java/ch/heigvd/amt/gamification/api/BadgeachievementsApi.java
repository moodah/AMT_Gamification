package ch.heigvd.amt.gamification.api;

import java.math.BigDecimal;

import ch.heigvd.amt.gamification.model.BadgeAchievement;
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

@Api(value = "badgeachievements", description = "the badgeachievements API")
public interface BadgeachievementsApi {

    @ApiOperation(value = "Get a list of badgeachievements for this application", notes = "", response = BadgeAchievement.class, responseContainer = "List", tags = {"Badgeachievements",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of badgeachievements", response = BadgeAchievement.class)})
    @RequestMapping(value = "/badgeachievements",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<BadgeAchievement>> badgeachievementsGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Delete badgeachievement with specified", notes = "", response = Void.class, tags = {"Badgeachievements",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class)})
    @RequestMapping(value = "/badgeachievements/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> badgeachievementsIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                   @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Get badgeachievement with specified id", notes = "", response = BadgeAchievement.class, tags = {"Badgeachievements",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requested badgeachievement", response = BadgeAchievement.class)})
    @RequestMapping(value = "/badgeachievements/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<BadgeAchievement> badgeachievementsIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                            @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Update badgeachievement with specified", notes = "", response = BadgeAchievement.class, tags = {"Badgeachievements",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Badgeachievement updated", response = BadgeAchievement.class)})
    @RequestMapping(value = "/badgeachievements/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PATCH)
    ResponseEntity<BadgeAchievement> badgeachievementsIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                              @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                              @ApiParam(value = "Updated badgeachievement", required = true) @RequestBody BadgeAchievement badgeachievement);


    @ApiOperation(value = "Create a new badgeachievement", notes = "", response = BadgeAchievement.class, tags = {"Badgeachievements",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Badgeachievement created", response = BadgeAchievement.class)})
    @RequestMapping(value = "/badgeachievements",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<BadgeAchievement> badgeachievementsPost(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                           @ApiParam(value = "New badgeachievement", required = true) @RequestBody BadgeAchievement badgeachievement);

}
