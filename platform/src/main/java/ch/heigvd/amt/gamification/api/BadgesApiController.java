package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.Error;
import java.math.BigDecimal;
import ch.heigvd.amt.gamification.model.Badge;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-13T18:36:02.067Z")

@RestController
public class BadgesApiController implements BadgesApi {

    public ResponseEntity<Void> badgesDelete(@ApiParam(value = "", required = true) @RequestParam(value = "id", required = true) BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Badge>> badgesGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<List<Badge>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> badgesIdDelete(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Badge> badgesIdGet(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Badge>(HttpStatus.OK);
    }

    public ResponseEntity<Badge> badgesIdPatch(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Badge>(HttpStatus.OK);
    }

    public ResponseEntity<Badge> badgesPost(@ApiParam(value = "" ,required=true ) @RequestBody Badge badge,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Badge>(HttpStatus.OK);
    }

}
