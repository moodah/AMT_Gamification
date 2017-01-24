package ch.heigvd.amt.gamification.dto;

import ch.heigvd.amt.gamification.model.Event;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * EventPresentationDTO
 */
public class EventPresentationDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("timestamp")
    private Date timestamp;

    @JsonProperty("application_id")
    private long application_id;

    @JsonProperty("user_id")
    private long user_id;

    @JsonProperty("eventtype_id")
    private long eventtype_id;

    public EventPresentationDTO(Event event) {
        id = event.getId();
        timestamp = event.getTimestamp();
        application_id = event.getApplication().getId();
        user_id = event.getUserId();
        eventtype_id = event.getEventtype().getId();
    }

    public long getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public long getApplication_id() {
        return application_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public long getEventtype_id() {
        return eventtype_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setApplication_id(long application_id) {
        this.application_id = application_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setEventtype_id(long eventtype_id) {
        this.eventtype_id = eventtype_id;
    }
}
