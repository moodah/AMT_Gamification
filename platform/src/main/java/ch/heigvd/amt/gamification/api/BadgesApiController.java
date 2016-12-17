package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.annotations.Authenticate;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.dao.BadgeDao;
import ch.heigvd.amt.gamification.model.Badge;

import java.math.BigDecimal;

import ch.heigvd.amt.gamification.model.HttpStatusException;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-16T15:16:07.537Z")

@RestController
public class BadgesApiController implements BadgesApi {

    @Autowired
    private BadgeDao badgeDao;

    public ResponseEntity<Void> badgesDelete(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Badge>> badgesGet(@ApiParam(value = "Application token" ,required=true ) @RequestHeader(value="Authorization", required=true) String authorization, HttpServletRequest request) {
        // do some magic!
        Application app = (Application) request.getAttribute("app");
        System.out.println("from badgesGet: " + app.getName() + ", " + app.getPassword());
        return new ResponseEntity<List<Badge>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> badgesIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                               @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Badge> badgesIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                             @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        Badge badge = badgeDao.findById(id.longValue());

        if(badge == null)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "There is no badge with this ID: " + id);

        return new ResponseEntity<Badge>(badge, HttpStatus.OK);
    }

    public ResponseEntity<Badge> badgesIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                               @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<Badge>(HttpStatus.OK);
    }


    public ResponseEntity<Badge> badgesPost(@ApiParam(value = "", required = true) @RequestBody Badge badge,
                                            @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        if (badge.getName() == null)
            throw new HttpStatusException(HttpStatus.CONFLICT, "Name is missing!");

        if (badge.getDescription() == null)
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Description is missing!");

        badgeDao.save(badge);

        return new ResponseEntity<Badge>(badge, HttpStatus.CREATED);
    }

}
