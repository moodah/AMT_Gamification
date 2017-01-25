package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dto.UserPresentationDTO;

import java.math.BigDecimal;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Controller
public class LeaderboardsApiController implements LeaderboardsApi {

    public ResponseEntity<List<UserPresentationDTO>> leaderboardsGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {

        return new ResponseEntity<List<UserPresentationDTO>>(HttpStatus.OK);
    }

}
