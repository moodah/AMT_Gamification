package ch.heigvd.amt.gamification.api;


import java.math.BigDecimal;

import ch.heigvd.amt.gamification.model.Achievement;
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
public class AchievementsApiController implements AchievementsApi {

    public ResponseEntity<List<Achievement>> achievementsGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<List<Achievement>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> achievementsIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                     @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Achievement> achievementsIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                         @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<Achievement>(HttpStatus.OK);
    }

    public ResponseEntity<Achievement> achievementsIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                           @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                           @ApiParam(value = "Updated achievement", required = true) @RequestBody Achievement achievement) {
        // do some magic!
        return new ResponseEntity<Achievement>(HttpStatus.OK);
    }

    public ResponseEntity<Achievement> achievementsPost(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                        @ApiParam(value = "New achievement", required = true) @RequestBody Achievement achievement) {
        // do some magic!
        return new ResponseEntity<Achievement>(HttpStatus.OK);
    }

}
