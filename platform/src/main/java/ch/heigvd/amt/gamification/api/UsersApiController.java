package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dao.EventDao;
import ch.heigvd.amt.gamification.dao.EventtypeDao;
import ch.heigvd.amt.gamification.dto.BadgePresentationDTO;
import ch.heigvd.amt.gamification.dto.LevelPresentationDTO;
import ch.heigvd.amt.gamification.dto.UserPresentationDTO;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.Event;
import ch.heigvd.amt.gamification.model.Eventtype;
import ch.heigvd.amt.gamification.model.Level;

import java.math.BigDecimal;

import ch.heigvd.amt.gamification.security.Authentication;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Controller
public class UsersApiController implements UsersApi {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private EventtypeDao eventtypeDao;


    public ResponseEntity<ArrayList<UserPresentationDTO>> usersGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                                   @ApiParam(value = "The page number", defaultValue = "1") @RequestParam(value = "page", required = false, defaultValue = "1") BigDecimal page,
                                                                   @ApiParam(value = "Number of result per page", defaultValue = "10") @RequestParam(value = "perPage", required = false, defaultValue = "10") BigDecimal perPage) {

        long appId = Authentication.getApplicationId(authorization);

        return new ResponseEntity<ArrayList<UserPresentationDTO>>(HttpStatus.OK);
    }

    public ResponseEntity<UserPresentationDTO> usersIdGet(@ApiParam(value = "The user's ID", required = true) @PathVariable("id") BigDecimal id,
                                                          @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {

        long appId = Authentication.getApplicationId(authorization);

        List<Event> events = eventDao.findAllByApplicationIdAndUserId(appId, id.longValue());

        long points = 0;

        if(events != null) {
            for (Event event : events) {
                points += event.getEventtype().getPoints().longValue();
            }
        }

        return new ResponseEntity<UserPresentationDTO>(new UserPresentationDTO(id.longValue(), points), HttpStatus.OK);
    }



    private LevelPresentationDTO toPresentationDTO(Level level) {
        return new LevelPresentationDTO(level);
    }

    private BadgePresentationDTO toPresentationDTO(Badge badge) {
        return new BadgePresentationDTO(badge);
    }
}
