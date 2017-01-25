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
        badgeDao.deleteAll();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Badge>> badgesGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        return new ResponseEntity<List<Badge>>(Lists.newArrayList(badgeDao.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<Void> badgesIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                               @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        Badge badge = badgeDao.findById(id.longValue());

        if (badge == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND, ErrorMessageGenerator.notFoundById("Badge", id.toString()));

        badgeDao.delete(id.longValue());

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Badge> badgesIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                             @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        Badge badge = badgeDao.findById(id.longValue());

        if (badge == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND, ErrorMessageGenerator.notFoundById("Badge", id.toString()));

        return new ResponseEntity<Badge>(badge, HttpStatus.OK);
    }

    public ResponseEntity<Badge> badgesIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                               @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                               @ApiParam(value = "Updated badge", required = true) @RequestBody Badge newBadge) {
        Badge oldBadge = badgeDao.findById(id.longValue());
        long appId = Authentication.getApplicationId(authorization);


        if (oldBadge == null)
            throw new HttpStatusException(HttpStatus.NOT_FOUND, ErrorMessageGenerator.notFoundById("Badge", id.toString()));

        if (newBadge.getId() != 0)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.cannotEditField("Badge", "id"));

        if (newBadge.getName() != null) {
            if (badgeDao.findByApplicationIdAndName(appId, newBadge.getName()) != null)
                throw new HttpStatusException(HttpStatus.CONFLICT, ErrorMessageGenerator.nameAlreadyExists("Badge", newBadge.getName()));
            else
                oldBadge.setName(newBadge.getName());
        }

        if (newBadge.getDescription() != null)
            oldBadge.setDescription(newBadge.getDescription());

        badgeDao.save(oldBadge);

        return new ResponseEntity<Badge>(oldBadge, HttpStatus.OK);
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

        if (badgeDTO.getAchievementsIds() != null) {
            badgeDTO.getAchievementsIds().forEach(aLong -> {
                if(achievementDao.findByApplicationIdAndId(appId, aLong) == null){
                    throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.notFoundById("Achievement", String.valueOf(aLong)));
                }
                badge.addAchievement(achievementDao.findByApplicationIdAndId(appId, aLong));
            });
        }

        badgeDao.save(badge);

        return new ResponseEntity<BadgePresentationDTO>(new BadgePresentationDTO(badge), HttpStatus.CREATED);
    }

    /*public ResponseEntity<Badge> badgesIdPatch(@ApiParam(value = "",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization,
        @ApiParam(value = "Updated badge" ,required=true ) @RequestBody Badge badge) {
        // do some magic!
        return new ResponseEntity<Badge>(HttpStatus.OK);
    }*/
}
