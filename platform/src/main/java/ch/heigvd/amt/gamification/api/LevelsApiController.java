package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.Level;
import java.math.BigDecimal;

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
public class LevelsApiController implements LevelsApi {

    public ResponseEntity<Void> levelsDelete(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Level>> levelsGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<List<Level>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> levelsIdDelete(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                               @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Level> levelsIdGet(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                             @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Level>(HttpStatus.OK);
    }

    public ResponseEntity<Level> levelsIdPatch(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                               @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Level>(HttpStatus.OK);
    }

    public ResponseEntity<Level> levelsPost(@ApiParam(value = "" ,required=true ) @RequestBody Level level,
                                            @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // do some magic!
        return new ResponseEntity<Level>(HttpStatus.OK);
    }

}

