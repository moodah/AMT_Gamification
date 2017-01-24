package ch.heigvd.amt.gamification.api;

import java.math.BigDecimal;

import ch.heigvd.amt.gamification.dao.ApplicationDao;
import ch.heigvd.amt.gamification.dao.EventtypeDao;
import ch.heigvd.amt.gamification.dto.EventtypeCreationDTO;
import ch.heigvd.amt.gamification.errors.ErrorMessageGenerator;
import ch.heigvd.amt.gamification.errors.HttpStatusException;
import ch.heigvd.amt.gamification.model.Error;
import ch.heigvd.amt.gamification.model.Eventtype;
import ch.heigvd.amt.gamification.security.Authentication;
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
public class EventtypesApiController implements EventtypesApi {

    @Autowired
    private EventtypeDao eventtypeDao;

    @Autowired
    private ApplicationDao applicationDao;

    public ResponseEntity<List<Eventtype>> eventtypesGet(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<List<Eventtype>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> eventtypesIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                   @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Eventtype> eventtypesIdGet(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                     @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization) {
        // do some magic!
        return new ResponseEntity<Eventtype>(HttpStatus.OK);
    }

    public ResponseEntity<Eventtype> eventtypesIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") BigDecimal id,
                                                       @ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                       @ApiParam(value = "Updated eventtype", required = true) @RequestBody EventtypeCreationDTO eventtypeDTO) {
        Eventtype eventtype = eventtypeDao.findById(id.intValue());

        if(eventtypeDTO.getName() != null){
            eventtype.setName(eventtypeDTO.getName());
        }

        if(eventtypeDTO.getPoints() != null){
            eventtype.setPoints(eventtypeDTO.getPoints());
        }

        eventtypeDao.save(eventtype);

        return new ResponseEntity<Eventtype>(eventtype, HttpStatus.OK);
    }

    public ResponseEntity<Eventtype> eventtypesPost(@ApiParam(value = "Application token", required = true) @RequestHeader(value = "Authorization", required = true) String authorization,
                                                    @ApiParam(value = "New eventtype", required = true) @RequestBody EventtypeCreationDTO eventtypeDTO) {
        dataValidation(eventtypeDTO);

        long appId = Authentication.getApplicationId(authorization);

        Eventtype eventtype = new Eventtype(eventtypeDTO.getName(),
                eventtypeDTO.getPoints(),
                applicationDao.findById(appId));

        eventtypeDao.save(eventtype);

        return new ResponseEntity<Eventtype>(eventtype, HttpStatus.OK);
    }

    private void dataValidation(EventtypeCreationDTO eventtypeDTO){
        if(eventtypeDTO.getName() == null) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Eventtype", "name"));
        }

        if(eventtypeDTO.getPoints() == null){
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, ErrorMessageGenerator.fieldMissing("Eventtype", "name"));
        }
    }
}
