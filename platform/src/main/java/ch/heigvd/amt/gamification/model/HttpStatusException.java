package ch.heigvd.amt.gamification.model;

import org.springframework.http.HttpStatus;

import javax.xml.ws.http.HTTPException;

/**
 * @author Christopher Browne
 * @version 1.0
 */
public class HttpStatusException extends RuntimeException {

    private HttpStatus status;

    public HttpStatusException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
