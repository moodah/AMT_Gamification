package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dto.BadgeCreationDTO;
import ch.heigvd.amt.gamification.dto.BadgePresentationDTO;
import ch.heigvd.amt.gamification.model.Badge;

import java.math.BigDecimal;

import ch.heigvd.amt.gamification.model.Eventtype;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Api(value = "badges", description = "the badges API")
public interface BadgesApi {

    @ApiOperation(value = "Get badges for this application", notes = "", response = Badge.class, responseContainer = "List", tags = {"Badges",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A list of badges", response = Badge.class)})
    @RequestMapping(value = "/badges",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<BadgePresentationDTO>> badgesGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Delete badge with specified", notes = "", response = Void.class, tags = {"Badges",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class)})
    @RequestMapping(value = "/badges/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> badgesIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                        @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Get badge with specified id", notes = "", response = Badge.class, tags = {"Badges",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requested badge", response = Badge.class)})
    @RequestMapping(value = "/badges/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<BadgePresentationDTO> badgesIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                      @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);


    @ApiOperation(value = "Update badge with specified id", notes = "", response = Badge.class, tags = {"Badges",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Badge updated", response = Badge.class)})
    @RequestMapping(value = "/badges/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PATCH)
    ResponseEntity<BadgePresentationDTO> badgesIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                        @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                        @ApiParam(value = "Updated badge", required = true) @RequestBody Badge badge);


    @ApiOperation(value = "Create a new badge", notes = "", response = Badge.class, tags = {"Badges",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Badge created", response = Badge.class)})
    @RequestMapping(value = "/badges",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<BadgePresentationDTO> badgesPost(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                    @ApiParam(value = "", required = true) @RequestBody BadgeCreationDTO badge);

    @ApiOperation(value = "Delete all badges of applications", notes = "", response = Void.class, tags = {"Badges",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class)})
    @RequestMapping(value = "/badges",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> badgesDelete(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization);
}
