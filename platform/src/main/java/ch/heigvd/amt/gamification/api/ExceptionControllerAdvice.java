package ch.heigvd.amt.gamification.api;

import ch.heigvd.amt.gamification.model.HttpErrorResponse;
import ch.heigvd.amt.gamification.model.HttpStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * @author Christopher Browne
 * @version 1.0
 */
@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {org.springframework.dao.DataIntegrityViolationException.class})
    protected ResponseEntity handleDataIntegrityViolation(RuntimeException ex, WebRequest request) {
        HttpErrorResponse err = new HttpErrorResponse();
        err.setCode(HttpStatus.CONFLICT.value());
        err.setMessage("Could not add this element. This is probably due to a duplicate column.");
        return new ResponseEntity<HttpErrorResponse>(err, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {HttpStatusException.class})
    protected ResponseEntity handleHttpStatus(HttpStatusException ex) {
        HttpErrorResponse err = new HttpErrorResponse();
        err.setCode(ex.getStatus().value());
        err.setMessage(ex.getMessage());
        return new ResponseEntity<HttpErrorResponse>(err, ex.getStatus());
    }
}