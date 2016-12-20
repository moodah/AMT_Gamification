package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.configuration.AppConfig;
import ch.heigvd.amt.gamification.dao.ApplicationDao;
import ch.heigvd.amt.gamification.dao.LevelDao;
import ch.heigvd.amt.gamification.errors.ErrorMessageGenerator;
import ch.heigvd.amt.gamification.errors.HttpStatusException;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Level;
import java.math.BigDecimal;

import ch.heigvd.amt.gamification.security.Authentication;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.LinkedList;
import java.util.List;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Controller
public class LevelsApiController implements LevelsApi {

    @Autowired
    LevelDao levelDao;

    @Autowired
    ApplicationDao applicationDao;

    public ResponseEntity<Void> levelsDelete(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);
        levelDao.delete(levelDao.findAllByApplicationIdOrderByPointsAsc(appId)); // TODO : une seule requete ? deleteAllByApplicationId par exemple (ne marchait pas quand j'ai essayé)

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<Level>> levelsGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);

        return new ResponseEntity<List<Level>>(levelDao.findAllByApplicationIdOrderByPointsAsc(appId), HttpStatus.OK);
    }

    public ResponseEntity<Void> levelsIdDelete(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                               @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);

        if (levelDao.findByApplicationIdAndId(appId, id.longValue()) == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND,
                    ErrorMessageGenerator.notFoundById("Level", id.toString()));

        levelDao.delete(id.longValue());

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Level> levelsIdGet(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                             @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);

        Level persistentLevel = levelDao.findByApplicationIdAndId(appId, id.longValue());
        if (persistentLevel == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND,
                    ErrorMessageGenerator.notFoundById("Level", id.toString()));

        return new ResponseEntity<Level>(persistentLevel, HttpStatus.OK);
    }

    public ResponseEntity<Level> levelsIdPatch(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
                                               @ApiParam(value = "", required=false) @RequestBody Level newLevel,
                                               @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);
        Level oldLevel = levelDao.findByApplicationIdAndId(appId, id.longValue());

        if(oldLevel == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND, ErrorMessageGenerator.notFoundById("Level", id.toString()));

        if(newLevel.getId() != 0)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.cannotEditField("Level", "id"));

        if(newLevel.getName() != null)
            oldLevel.setName(newLevel.getName());

        if(newLevel.getPoints() != null)
            oldLevel.setPoints(newLevel.getPoints());

        levelDao.save(oldLevel);

        return new ResponseEntity<Level>(oldLevel, HttpStatus.OK);
    }

    public ResponseEntity<List<String>> levelsPost(@ApiParam(value = "" ,required=true ) @RequestBody List<Level> levels,
                                            @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization) {
        // levels payload verification
        levels.forEach(level -> {
            String levelName = level.getName();
            BigDecimal levelPoints = level.getPoints();

            if (levelName == null)
                throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Level", "name"));

            if (levelPoints == null)
                throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Level", "points"));

            if (levelName.length() < 0)
                throw new HttpStatusException(HttpStatus.BAD_REQUEST,
                        ErrorMessageGenerator.fieldTooShort("Level", "name", AppConfig.MIN_APP_NAME_LENGTH));

            if (levelPoints.longValue() < 0L)
                throw new HttpStatusException(HttpStatus.BAD_REQUEST,
                        ErrorMessageGenerator.valueTooSmall("Level", "points", 0));
        });

        // Get application id from token
        long appId = Authentication.getApplicationId(authorization);
        Application app = applicationDao.findOne(appId);

        // levels insertion (only if not existing yet
        List<String> urls = new LinkedList<>();
        levels.forEach(level -> {
            long levelId = 0;
            Level oldLevel = levelDao.findByApplicationIdAndName(appId, level.getName());

            if (oldLevel == null) {
                level.setApplication(app);
                levelId = levelDao.save(level).getId();
            } else {
                levelId = oldLevel.getId();
            }

            urls.add("/levels/" + levelId);
        });

        return new ResponseEntity<List<String>>(urls, HttpStatus.CREATED);
    }

}

