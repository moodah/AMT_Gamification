package ch.heigvd.amt.gamification.dto;

import java.util.LinkedList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * EventtypeDTO
 */
public class EventCreationDTO {

    @JsonProperty("user_id")
    private int user_id;

    @JsonProperty("eventtype_id")
    private long eventtype_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public long getEventtype_id() {
        return eventtype_id;
    }

    public void setEventtype_id(long eventtype_id) {
        this.eventtype_id = eventtype_id;
    }
}
