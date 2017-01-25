package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.dao.AchievementDao;
import ch.heigvd.amt.gamification.dao.ApplicationDao;
import ch.heigvd.amt.gamification.dao.BadgeDao;
import ch.heigvd.amt.gamification.dto.BadgeCreationDTO;
import ch.heigvd.amt.gamification.dto.BadgePresentationDTO;
import ch.heigvd.amt.gamification.errors.ErrorMessageGenerator;
import ch.heigvd.amt.gamification.model.Badge;

import java.math.BigDecimal;

import ch.heigvd.amt.gamification.errors.HttpStatusException;
import ch.heigvd.amt.gamification.security.Authentication;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@RestController
public class BadgesApiController implements BadgesApi {

    @Autowired
    private BadgeDao badgeDao;

    @Autowired
    private ApplicationDao applicationsDao;

    @Autowired
    private AchievementDao achievementDao;

    public ResponseEntity<Void> badgesDelete(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {

        long appId = Authentication.getApplicationId(authorization);

        badgeDao.findAllByApplicationId(appId).forEach(badge -> {
            badgeDao.delete(badge);
        });

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<BadgePresentationDTO>> badgesGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);
        List<Badge> badges = badgeDao.findAllByApplicationId(appId);

        List<BadgePresentationDTO> badgePresentationDTOList = new ArrayList<>();

        badges.forEach(badge -> {
            badgePresentationDTOList.add(new BadgePresentationDTO(badge));
        });

        return new ResponseEntity<List<BadgePresentationDTO>>(badgePresentationDTOList, HttpStatus.OK);
    }

    public ResponseEntity<Void> badgesIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                               @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);

        badgeDao.delete(badgeDao.findByApplicationIdAndId(appId, id.longValue()));

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<BadgePresentationDTO> badgesIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                             @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        long appId = Authentication.getApplicationId(authorization);

        Badge badge = badgeDao.findByApplicationIdAndId(appId, id.longValue());

        if (badge == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND, ErrorMessageGenerator.notFoundById("Badge", id.toString()));

        return new ResponseEntity<BadgePresentationDTO>(new BadgePresentationDTO(badge), HttpStatus.OK);
    }

    public ResponseEntity<BadgePresentationDTO> badgesIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                               @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                               @ApiParam(value = "Updated badge", required = true) @RequestBody BadgeCreationDTO newBadge) {
        long appId = Authentication.getApplicationId(authorization);

        Badge oldBadge = badgeDao.findByApplicationIdAndId(appId, id.longValue());

        if (newBadge.getName() != null) {
            if (badgeDao.findByApplicationIdAndName(appId, newBadge.getName()) != null)
                throw new HttpStatusException(HttpStatus.CONFLICT, ErrorMessageGenerator.nameAlreadyExists("Badge", newBadge.getName()));
            else
                oldBadge.setName(newBadge.getName());
        }

        if (newBadge.getDescription() != null)
            oldBadge.setDescription(newBadge.getDescription());

        if (newBadge.getAchievementsIds() != null){
            oldBadge.getAchievements().clear();
            newBadge.getAchievementsIds().forEach(aLong -> {
                oldBadge.addAchievement(achievementDao.findByApplicationIdAndId(appId, aLong));
            });
        }

        badgeDao.save(oldBadge);

        return new ResponseEntity<BadgePresentationDTO>(new BadgePresentationDTO(oldBadge), HttpStatus.OK);
    }


    public ResponseEntity<BadgePresentationDTO> badgesPost(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                           @ApiParam(value = "", required = true) @RequestBody BadgeCreationDTO badgeDTO) {
        long appId = Authentication.getApplicationId(authorization);

        if (badgeDTO.getName() == null)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Badge", "name"));

        if (badgeDTO.getDescription() == null)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Badge", "description"));

        if (badgeDao.findByApplicationIdAndName(appId, badgeDTO.getName()) != null)
            throw new HttpStatusException(HttpStatus.CONFLICT, ErrorMessageGenerator.nameAlreadyExists("Badge", badgeDTO.getName()));

        Badge badge = new Badge(badgeDTO.getName(), badgeDTO.getDescription(), applicationsDao.findById(appId));

        List<Long> achievementIds = badgeDTO.getAchievementsIds();

        if (achievementIds == null || achievementIds.size() == 0) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Badge", "Achievements"));
        }

        achievementIds.forEach(aLong -> {
            badge.addAchievement(achievementDao.findByApplicationIdAndId(appId, aLong));
        });

        badgeDao.save(badge);

        return new ResponseEntity<BadgePresentationDTO>(new BadgePresentationDTO(badge), HttpStatus.CREATED);
    }
}
