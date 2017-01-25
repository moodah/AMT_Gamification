package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.configuration.AppConfig;
import ch.heigvd.amt.gamification.dao.ApplicationDao;
import ch.heigvd.amt.gamification.dao.LevelDao;
import ch.heigvd.amt.gamification.dto.LevelCreationDTO;
import ch.heigvd.amt.gamification.dto.LevelPresentationDTO;
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

import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Controller
public class LevelsApiController implements LevelsApi {

    @Autowired
    LevelDao levelDao;

    @Autowired
    ApplicationDao applicationDao;

    public ResponseEntity<ArrayList<LevelPresentationDTO>> levelsGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);

        ArrayList<LevelPresentationDTO> levels = new ArrayList<>();
        levelDao.findAllByApplicationIdOrderByPointsAsc(appId)
                .forEach(level -> levels.add(toPresentationDTO(level)));

        return new ResponseEntity<ArrayList<LevelPresentationDTO>>(levels, HttpStatus.OK);
    }

    public ResponseEntity<Void> levelsIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                               @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);

        Level level = levelDao.findByApplicationIdAndId(appId, id.longValue());
        if (level == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND, ErrorMessageGenerator.notFoundById("Level", id.toString()));

        levelDao.delete(level);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<LevelPresentationDTO> levelsIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                            @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);

        Level persistentLevel = levelDao.findByApplicationIdAndId(appId, id.longValue());

        return new ResponseEntity<LevelPresentationDTO>(toPresentationDTO(persistentLevel), HttpStatus.OK);
    }

    public ResponseEntity<LevelPresentationDTO> levelsIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                              @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                              @ApiParam(value = "Updated level", required = true) @RequestBody LevelCreationDTO newLevel) {
        long appId = Authentication.getApplicationId(authorization);
        Level oldLevel = levelDao.findByApplicationIdAndId(appId, id.longValue());

        if (oldLevel == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND, ErrorMessageGenerator.notFoundById("Level", id.toString()));

        List<Level> levels = levelDao.findAllByApplicationId(appId);

        // Check if name already exists
        if (newLevel.getName() != null) {

            levels.forEach(level -> {
                if (level.getId() != id.longValue()) {
                    if (level.getName().equals(newLevel.getName()))
                        throw new HttpStatusException(HttpStatus.CONFLICT, ErrorMessageGenerator.nameAlreadyExists("Level", newLevel.getName()));
                }
            });

            oldLevel.setName(newLevel.getName());
        }

        // check if points already exist
        if (newLevel.getPoints() != null) {

            levels.forEach(level -> {
                if (level.getId() != id.longValue()) {
                    System.out.println("level points = " + level.getPoints() + ", newlevel pints = " + newLevel.getPoints());
                    if (level.getPoints() == newLevel.getPoints())
                        throw new HttpStatusException(HttpStatus.CONFLICT,
                                ErrorMessageGenerator.valueAlreadyExists("Level", "points", newLevel.getPoints()));
                }
            });

            oldLevel.setPoints(newLevel.getPoints());
        }

        levelDao.save(oldLevel);

        return new ResponseEntity<LevelPresentationDTO>(toPresentationDTO(oldLevel), HttpStatus.OK);
    }

    public ResponseEntity<LevelPresentationDTO> levelsPost(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                            @ApiParam(value = "", required = true) @RequestBody LevelCreationDTO levelDTO) {    // levels payload verification

        String levelName = levelDTO.getName();
        Long levelPoints = levelDTO.getPoints();

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


        // Get application id from token
        long appId = Authentication.getApplicationId(authorization);
        Application app = applicationDao.findOne(appId);

        Level level = new Level(levelDTO);
        level.setApplication(app);

        levelDao.save(level);

        return new ResponseEntity<LevelPresentationDTO>(new LevelPresentationDTO(level), HttpStatus.CREATED);
    }

    public ResponseEntity<Void> levelsDelete(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);

        levelDao.deleteByApplicationId(appId);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    private LevelPresentationDTO toPresentationDTO(Level level) {
        return new LevelPresentationDTO(level);
    }
}

