package ch.heigvd.amt.gamification.api;

import java.math.BigDecimal;

import ch.heigvd.amt.gamification.model.BadgeAchievement;
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


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-01-24T12:55:51.106Z")

@Controller
public class BadgeachievementsApiController implements BadgeachievementsApi {

    public ResponseEntity<List<BadgeAchievement>> badgeachievementsGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<List<BadgeAchievement>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> badgeachievementsIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                          @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<BadgeAchievement> badgeachievementsIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                                   @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<BadgeAchievement>(HttpStatus.OK);
    }

    public ResponseEntity<BadgeAchievement> badgeachievementsIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                                     @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                                     @ApiParam(value = "Updated badgeachievement", required = true) @RequestBody BadgeAchievement badgeachievement) {
        // do some magic!
        return new ResponseEntity<BadgeAchievement>(HttpStatus.OK);
    }

    public ResponseEntity<BadgeAchievement> badgeachievementsPost(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                                  @ApiParam(value = "New badgeachievement", required = true) @RequestBody BadgeAchievement badgeachievement) {
        // do some magic!
        return new ResponseEntity<BadgeAchievement>(HttpStatus.OK);
    }

}
