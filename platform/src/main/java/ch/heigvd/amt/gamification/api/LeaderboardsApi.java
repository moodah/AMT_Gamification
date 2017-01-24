package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.User;

import java.math.BigDecimal;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Api(value = "leaderboards", description = "the leaderboards API")
public interface LeaderboardsApi {

    @ApiOperation(value = "Get a list of top users", notes = "", response = User.class, responseContainer = "List", tags = {"Leaderboards", "Users",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "An list of users, ordered by their global reputation", response = User.class)})
    @RequestMapping(value = "/leaderboards",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<User>> leaderboardsGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                               @ApiParam(value = "The page number", defaultValue = "1") @RequestParam(value = "page", required = false, defaultValue = "1") BigDecimal page,
                                               @ApiParam(value = "Number of result per page", defaultValue = "10") @RequestParam(value = "perPage", required = false, defaultValue = "10") BigDecimal perPage);

}

