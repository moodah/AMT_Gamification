package ch.heigvd.amt.gamification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * EventtypeDTO
 */
public class EventCreationDTO {

    @JsonProperty("user_id")
    private Long user_id;

    @JsonProperty("eventtype_id")
    private Long eventtype_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getEventtype_id() {
        return eventtype_id;
    }

    public void setEventtype_id(Long eventtype_id) {
        this.eventtype_id = eventtype_id;
    }
}
