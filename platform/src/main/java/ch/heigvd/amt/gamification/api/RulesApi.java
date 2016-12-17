package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.Rule;
import java.math.BigDecimal;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-16T15:16:07.537Z")

@Api(value = "rules", description = "the rules API")
public interface RulesApi {

    @ApiOperation(value = "Delete all rules", notes = "Delete all rules for this application", response = Void.class, tags={ "Rules", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class),
        @ApiResponse(code = 200, message = "HttpErrorResponse payload", response = Void.class) })
    @RequestMapping(value = "/rules",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> rulesDelete(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Get Gamification rules", notes = "The Rules endpoint returns the rules defined by the client", response = Rule.class, responseContainer = "List", tags={ "Rules", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of rules", response = Rule.class),
        @ApiResponse(code = 200, message = "HttpErrorResponse payload", response = Rule.class) })
    @RequestMapping(value = "/rules",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Rule>> rulesGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Delete the rule with {id}", notes = "Delete the rule with {id}", response = Void.class, tags={ "Rules", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted successfully", response = Void.class),
        @ApiResponse(code = 200, message = "HttpErrorResponse payload", response = Void.class) })
    @RequestMapping(value = "/rules/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> rulesIdDelete(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Get a rule specified by {id}", notes = "Get a rule specified by {id}", response = Rule.class, tags={ "Rules", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Requested rule", response = Rule.class),
        @ApiResponse(code = 200, message = "HttpErrorResponse payload", response = Rule.class) })
    @RequestMapping(value = "/rules/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Rule> rulesIdGet(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Update rules with {id}", notes = "Update rules with {id}", response = Rule.class, tags={ "Rules", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated rule", response = Rule.class),
        @ApiResponse(code = 200, message = "HttpErrorResponse payload", response = Rule.class) })
    @RequestMapping(value = "/rules/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    ResponseEntity<Rule> rulesIdPatch(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);


    @ApiOperation(value = "Create Gamification rules", notes = "The Rules endpoint allows the client to submit new rules", response = Rule.class, tags={ "Rules", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Newly created rule", response = Rule.class),
        @ApiResponse(code = 200, message = "HttpErrorResponse payload", response = Rule.class) })
    @RequestMapping(value = "/rules",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Rule> rulesPost(@ApiParam(value = "" ,required=true ) @RequestBody Rule rule,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization);

}
