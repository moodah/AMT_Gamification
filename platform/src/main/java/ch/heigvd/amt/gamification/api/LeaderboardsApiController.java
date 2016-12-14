package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.Error;
import ch.heigvd.amt.gamification.model.Reputation;
import java.math.BigDecimal;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-13T18:36:02.067Z")

@Controller
public class LeaderboardsApiController implements LeaderboardsApi {

    public ResponseEntity<List<Reputation>> leaderboardsGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization,
        @ApiParam(value = "The page number", defaultValue = "1") @RequestParam(value = "page", required = false, defaultValue="1") BigDecimal page,
        @ApiParam(value = "Number of result per page", defaultValue = "10") @RequestParam(value = "perPage", required = false, defaultValue="10") BigDecimal perPage) {
        // do some magic!
        return new ResponseEntity<List<Reputation>>(HttpStatus.OK);
    }

}
