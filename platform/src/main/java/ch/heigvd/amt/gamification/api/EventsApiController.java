package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dao.*;
import ch.heigvd.amt.gamification.dto.EventCreationDTO;
import ch.heigvd.amt.gamification.dto.EventtypeCreationDTO;
import ch.heigvd.amt.gamification.dto.EventtypePresentationDTO;
import ch.heigvd.amt.gamification.errors.ErrorMessageGenerator;
import ch.heigvd.amt.gamification.errors.HttpStatusException;
import ch.heigvd.amt.gamification.model.*;

import ch.heigvd.amt.gamification.security.Authentication;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.Date;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Controller
public class EventsApiController implements EventsApi {

    public ResponseEntity<Event> eventsPost(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization,
        @ApiParam(value = "New event" ,required=true ) @RequestBody Event event) {
        // do some magic!
        return new ResponseEntity<Event>(HttpStatus.OK);
    }

}
