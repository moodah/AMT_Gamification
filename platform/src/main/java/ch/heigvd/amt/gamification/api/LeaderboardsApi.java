package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.Error;
import ch.heigvd.amt.gamification.model.Reputation;
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

@Api(value = "leaderboards", description = "the leaderboards API")
public interface LeaderboardsApi {

    @ApiOperation(value = "Get top users", notes = "The Leaderboards endpoint returns a list of the top users.", response = Reputation.class, responseContainer = "List", tags={ "Leaderboards", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of users, ordered by their global reputation", response = Reputation.class),
        @ApiResponse(code = 200, message = "Error payload", response = Reputation.class) })
    @RequestMapping(value = "/leaderboards",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Reputation>> leaderboardsGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization,
        @ApiParam(value = "The page number", defaultValue = "1") @RequestParam(value = "page", required = false, defaultValue="1") BigDecimal page,
        @ApiParam(value = "Number of result per page", defaultValue = "10") @RequestParam(value = "perPage", required = false, defaultValue="10") BigDecimal perPage);

}
