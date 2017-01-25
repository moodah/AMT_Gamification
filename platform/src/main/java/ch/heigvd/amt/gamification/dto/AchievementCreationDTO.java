package ch.heigvd.amt.gamification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AchievementCreationDTO
 */
public class AchievementCreationDTO {

    @JsonProperty("count")
    private Long count;

    @JsonProperty("eventtype_id")
    private Long eventtype_id;

    @JsonProperty("name")
    private String name;

    public Long getCount() {
        return count;
    }

    public Long getEventtype_id() {
        return eventtype_id;
    }

    public String getName() {
        return name;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setEventtype_id(Long eventtype_id) {
        this.eventtype_id = eventtype_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
