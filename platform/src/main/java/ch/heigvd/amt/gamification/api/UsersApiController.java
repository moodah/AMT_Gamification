package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dao.*;
import ch.heigvd.amt.gamification.dto.BadgePresentationDTO;
import ch.heigvd.amt.gamification.dto.LevelPresentationDTO;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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

        HashMap<Eventtype, Integer> eventtypeIntegerHashMap = new HashMap<>();

        long points = 0;

        if(events != null) {
            for (Event event : events) {
                points += event.getEventtype().getPoints().longValue();
                Integer count = eventtypeIntegerHashMap.get(event.getEventtype());
                if(count == null) {
                    eventtypeIntegerHashMap.put(event.getEventtype(), 0);
                } else {
                    count = count + 1;
                }
            }
        }

        List<Achievement> potentialAchievements = new ArrayList<>();
        eventtypeIntegerHashMap.forEach((eventtype, integer) -> {
            achievementDao.findAllByApplicationIdAndEventtype(appId, eventtype).forEach(achievement -> {
                if(!potentialAchievements.contains(achievement)){
                    potentialAchievements.add(achievement);
                }
            });
        });

        List<Achievement> achievements = new ArrayList<>();
        potentialAchievements.forEach(achievement -> {
            eventtypeIntegerHashMap.forEach((eventtype, integer) -> {
                if(achievement.getEventtype() == eventtype && achievement.getCount() <= integer){
                    achievements.add(achievement);
                }
            });
        });

        List<Badge> potentialBadges = badgeDao.findAllByApplicationId(appId);
        List<Badge> badges = new ArrayList<>();

        potentialBadges.forEach(badge -> {
            int c = badge.getAchievements().size();
            for (Achievement achievement : badge.getAchievements()){
                if(achievements.contains(achievement)){
                    c--;
                }
            }
            if(c == 0){
                badges.add(badge);
            }
        });

        Level level = levelDao.findTopByPointsLessThanEqualOrderByPointsDesc(new BigDecimal(points));

        LevelPresentationDTO levelPresentationDTO;

        if (level == null) {
            levelPresentationDTO = new LevelPresentationDTO(0, "none", new BigDecimal(0));
        } else {
            levelPresentationDTO = new LevelPresentationDTO(level);
        }

        List<BadgePresentationDTO> badgePresentationDTOList = new ArrayList<>();
        badges.forEach(badge -> {
            badgePresentationDTOList.add(new BadgePresentationDTO(badge));
        });

        return new ResponseEntity<UserPresentationDTO>(
                new UserPresentationDTO(id.longValue(),
                points,
                levelPresentationDTO,
                badgePresentationDTOList), HttpStatus.OK);
    }
}
