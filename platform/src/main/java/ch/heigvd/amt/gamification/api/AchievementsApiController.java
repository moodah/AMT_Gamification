package ch.heigvd.amt.gamification.api;


import java.math.BigDecimal;

import ch.heigvd.amt.gamification.dao.AchievementDao;
import ch.heigvd.amt.gamification.dao.ApplicationDao;
import ch.heigvd.amt.gamification.dao.EventtypeDao;
import ch.heigvd.amt.gamification.dto.AchievementCreationDTO;
import ch.heigvd.amt.gamification.errors.ErrorMessageGenerator;
import ch.heigvd.amt.gamification.errors.HttpStatusException;
import ch.heigvd.amt.gamification.model.Achievement;
import ch.heigvd.amt.gamification.security.Authentication;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-01-24T12:55:51.106Z")

@Controller
public class AchievementsApiController implements AchievementsApi {

    @Autowired
    private AchievementDao achievementDao;

    @Autowired
    private ApplicationDao applicationDao;

    @Autowired
    private EventtypeDao eventtypeDao;

    public ResponseEntity<List<Achievement>> achievementsGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);
        return new ResponseEntity<List<Achievement>>(Lists.newArrayList(achievementDao.findAllByApplicationId(appId)), HttpStatus.OK);
    }

    public ResponseEntity<Void> achievementsIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                     @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);
        Achievement achievement = achievementDao.findByApplicationIdAndId(appId, id.longValue());

        if (achievement == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND, ErrorMessageGenerator.notFoundById("Archievement", id.toString()));

        achievementDao.delete(id.longValue());

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Achievement> achievementsIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                         @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);
        Achievement achievement = achievementDao.findByApplicationIdAndId(appId, id.longValue());

        if (achievement == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND, ErrorMessageGenerator.notFoundById("Badge", id.toString()));

        return new ResponseEntity<Achievement>(achievement, HttpStatus.OK);
    }

    public ResponseEntity<Achievement> achievementsIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                           @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                           @ApiParam(value = "Updated achievement", required = true) @RequestBody AchievementCreationDTO newAchievement) {
        long appId = Authentication.getApplicationId(authorization);

        Achievement achievement = achievementDao.findByApplicationIdAndId(appId, id.longValue());

        if (achievement == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND, ErrorMessageGenerator.notFoundById("Badge", id.toString()));

        if (newAchievement.getCount() != null) {
            achievement.setCount(newAchievement.getCount().intValue());
        }
        if (newAchievement.getEventtype_id() != null) {
            achievement.setEventtype(eventtypeDao.findByApplicationIdAndId(appId, newAchievement.getEventtype_id().longValue()));
        }

        achievementDao.save(achievement);
        return new ResponseEntity<Achievement>(achievement, HttpStatus.OK);
    }

    public ResponseEntity<Achievement> achievementsPost(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                        @ApiParam(value = "New achievement", required = true) @RequestBody AchievementCreationDTO achievementDTO) {
        long appId = Authentication.getApplicationId(authorization);
        dataValidation(achievementDTO, appId);

        Achievement achievement = new Achievement(achievementDTO.getCount().intValue(),
                applicationDao.findById(appId),
                eventtypeDao.findByApplicationIdAndId(appId, achievementDTO.getEventtype_id().longValue()),
                achievementDTO.getName());

        achievementDao.save(achievement);

        return new ResponseEntity<Achievement>(achievement, HttpStatus.CREATED);
    }

    private void dataValidation(AchievementCreationDTO achievement, long appId) {
        if (achievement.getCount() == null) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Achievement", "count"));
        }
        if (achievement.getEventtype_id() == null) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Achievement", "eventtype_id"));
        }
        if (eventtypeDao.findByApplicationIdAndId(appId, achievement.getEventtype_id().longValue()) == null) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.notFoundById("eventtype", String.valueOf(achievement.getEventtype_id())));
        }
    }
}
