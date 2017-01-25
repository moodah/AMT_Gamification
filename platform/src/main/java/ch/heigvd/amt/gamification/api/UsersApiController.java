package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dao.*;
import ch.heigvd.amt.gamification.dto.UserPresentationDTO;
import ch.heigvd.amt.gamification.model.*;

import java.math.BigDecimal;

import ch.heigvd.amt.gamification.security.Authentication;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.List;

import static ch.heigvd.amt.gamification.utils.utils.getUserInfo;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Controller
public class UsersApiController implements UsersApi {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private EventtypeDao eventtypeDao;

    @Autowired
    private LevelDao levelDao;

    @Autowired
    private AchievementDao achievementDao;

    @Autowired
    private BadgeDao badgeDao;

    public ResponseEntity<List<UserPresentationDTO>> usersGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {

        long appId = Authentication.getApplicationId(authorization);

        List<Event> events = eventDao.findAllByApplicationId(appId);
        List<Long> userIds = new ArrayList<>();

        events.forEach(event -> {
            if(!userIds.contains(event.getUserId())){
                userIds.add(event.getUserId());
            }
        });

        List<UserPresentationDTO> userPresentationDTOS = new ArrayList<>();

        userIds.forEach(aLong -> {
            userPresentationDTOS.add(getUserInfo(appId, aLong, achievementDao, badgeDao, eventDao, levelDao));
        });

        return new ResponseEntity<List<UserPresentationDTO>>(userPresentationDTOS, HttpStatus.OK);
    }

    public ResponseEntity<UserPresentationDTO> usersIdGet(@ApiParam(value = "The user's ID", required = true) @PathVariable("id") BigDecimal id,
                                                          @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {

        long appId = Authentication.getApplicationId(authorization);

        UserPresentationDTO userDTO = getUserInfo(appId, id.longValue(), achievementDao, badgeDao, eventDao, levelDao);

        return new ResponseEntity<UserPresentationDTO>(userDTO, HttpStatus.OK);
    }
}
