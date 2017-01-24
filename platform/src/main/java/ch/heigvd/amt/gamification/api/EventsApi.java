package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dto.EventCreationDTO;
import ch.heigvd.amt.gamification.dto.EventPresentationDTO;
import ch.heigvd.amt.gamification.dto.EventtypeCreationDTO;

import ch.heigvd.amt.gamification.dto.EventtypePresentationDTO;
import ch.heigvd.amt.gamification.errors.ErrorMessageGenerator;
import ch.heigvd.amt.gamification.model.Event;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Api(value = "events", description = "the events API")
public interface EventsApi {

    @ApiOperation(value = "Create a new event (should be called automatically by the gamified application)", notes = "", response = Event.class, tags={ "Events", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Event created", response = Event.class) })
    @RequestMapping(value = "/events",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<EventPresentationDTO> eventsPost(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization,
                                                    @ApiParam(value = "New event" ,required=true ) @RequestBody EventCreationDTO event);

}