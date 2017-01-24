package ch.heigvd.amt.gamification.api;


import java.math.BigDecimal;

import ch.heigvd.amt.gamification.dao.AchievementDao;
import ch.heigvd.amt.gamification.dao.ApplicationDao;
import ch.heigvd.amt.gamification.dao.EventtypeDao;
import ch.heigvd.amt.gamification.dto.AchievementCreationDTO;
import ch.heigvd.amt.gamification.errors.ErrorMessageGenerator;
import ch.heigvd.amt.gamification.errors.HttpStatusException;
import ch.heigvd.amt.gamification.model.Achievement;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Eventtype;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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
        // do some magic!
        return new ResponseEntity<List<Achievement>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> achievementsIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                     @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Achievement> achievementsIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                         @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<Achievement>(HttpStatus.OK);
    }

    public ResponseEntity<Achievement> achievementsIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                           @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                           @ApiParam(value = "Updated achievement", required = true) @RequestBody Achievement achievement) {
        // do some magic!
        return new ResponseEntity<Achievement>(HttpStatus.OK);
    }

    public ResponseEntity<Achievement> achievementsPost(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                        @ApiParam(value = "New achievement", required = true) @RequestBody AchievementCreationDTO achievementDTO) {
        dataValidation(achievementDTO);

        Achievement achievement = new Achievement(achievementDTO.getCount().intValue(),
                applicationDao.findById(achievementDTO.getApplication_id().longValue()),
                eventtypeDao.findById(achievementDTO.getEventtype_id().longValue()),
                achievementDTO.getName());

        achievementDao.save(achievement);

        return new ResponseEntity<Achievement>(achievement, HttpStatus.OK);
    }

    private void dataValidation(AchievementCreationDTO achievement) {
        if (achievement.getCount() == null) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Achievement", "count"));
        }

        if (achievement.getEventtype_id() == null) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Achievement", "eventtype_id"));
        }

        if (achievement.getApplication_id() == null) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Achievement", "application_id"));
        }
    }
}
