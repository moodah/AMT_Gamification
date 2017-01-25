package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dao.*;
import ch.heigvd.amt.gamification.dto.UserPresentationDTO;

import ch.heigvd.amt.gamification.model.Event;
import ch.heigvd.amt.gamification.security.Authentication;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ch.heigvd.amt.gamification.utils.utils.getUserInfo;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Controller
public class LeaderboardsApiController implements LeaderboardsApi {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private LevelDao levelDao;

    @Autowired
    private AchievementDao achievementDao;

    @Autowired
    private BadgeDao badgeDao;

    public ResponseEntity<List<UserPresentationDTO>> leaderboardsGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {

        long appId = Authentication.getApplicationId(authorization);

        List<Event> events = eventDao.findAllByApplicationId(appId);
        List<Long> userIds = new ArrayList<>();

        events.forEach(event -> {
            if(!userIds.contains(event.getUserId())){
                userIds.add(event.getUserId());
            }
        });

        List<UserPresentationDTO> userPresentationDTOS = new ArrayList<>();

        for (Long userId : userIds) {
            userPresentationDTOS.add(getUserInfo(appId, userId, achievementDao, badgeDao, eventDao, levelDao));

        }

        userPresentationDTOS.sort((o1, o2) -> (int)(o1.getPoints() - o2.getPoints()));

        userPresentationDTOS = userPresentationDTOS
                .stream()
                .sorted((o1, o2) -> (int)(o2.getPoints() - o1.getPoints()))
                .limit(10)
                .collect(Collectors.toList());

        return new ResponseEntity<List<UserPresentationDTO>>(userPresentationDTOS, HttpStatus.OK);
    }

}
