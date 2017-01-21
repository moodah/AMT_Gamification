package ch.heigvd.amt.gamification.api;

import java.math.BigDecimal;

import ch.heigvd.amt.gamification.model.Badge;
import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Controller
public class RulesApiController implements RulesApi {

    public ResponseEntity<Void> rulesDelete(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Badge>> rulesGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<List<Badge>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> rulesIdDelete(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                              @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Badge> rulesIdGet(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                           @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Badge>(HttpStatus.OK);
    }

    public ResponseEntity<Badge> rulesIdPatch(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                             @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Badge>(HttpStatus.OK);
    }

    public ResponseEntity<Badge> rulesPost(@ApiParam(value = "" ,required=true ) @RequestBody Badge rule,
                                          @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Badge>(HttpStatus.OK);
    }

}
