package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.Badge;
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

@Api(value = "badges", description = "the badges API")
public interface BadgesApi {

    @ApiOperation(value = "Delete all badges", notes = "Delete all badges for this application", response = Void.class, tags={ "Badges", })
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class),
            @ApiResponse(code = 200, message = "Error payload", response = Void.class) })
    @RequestMapping(value = "/badges",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> badgesDelete(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Get Gamification badges", notes = "The badges endpoint returns the badges defined by the client", response = Badge.class, responseContainer = "List", tags={ "Badges", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "An array of badges", response = Badge.class),
            @ApiResponse(code = 200, message = "Error payload", response = Badge.class) })
    @RequestMapping(value = "/badges",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Badge>> badgesGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Delete badge with {id}", notes = "Delete badge with {id}", response = Void.class, tags={ "Badges", })
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class),
            @ApiResponse(code = 200, message = "Error payload", response = Void.class) })
    @RequestMapping(value = "/badges/{id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> badgesIdDelete(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Get badge with {id}", notes = "Get badge with {id}", response = Badge.class, tags={ "Badges", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requested badge", response = Badge.class),
            @ApiResponse(code = 200, message = "Error payload", response = Badge.class) })
    @RequestMapping(value = "/badges/{id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Badge> badgesIdGet(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                      @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Update badge with {id}", notes = "Update", response = Badge.class, tags={ "Badges", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Updated badge", response = Badge.class),
            @ApiResponse(code = 200, message = "Error payload", response = Badge.class) })
    @RequestMapping(value = "/badges/{id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PATCH)
    ResponseEntity<Badge> badgesIdPatch(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                        @ApiParam(value = "", required=false) @RequestBody Badge badge,
                                        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Create Gamification badges", notes = "The badges endpoint allows the client to submit new badges", response = Badge.class, tags={ "Badges", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Newly created badge", response = Badge.class),
            @ApiResponse(code = 200, message = "Error payload", response = Badge.class) })
    @RequestMapping(value = "/badges",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Badge> badgesPost(@ApiParam(value = "" ,required=true ) @RequestBody Badge badge,
                                     @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);

}
