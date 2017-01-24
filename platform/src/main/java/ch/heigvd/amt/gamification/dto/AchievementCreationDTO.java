package ch.heigvd.amt.gamification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * AchievementCreationDTO
 */
public class AchievementCreationDTO {

    @JsonProperty("count")
    private BigDecimal count;

    @JsonProperty("eventtype_id")
    private BigDecimal eventtype_id;

    @JsonProperty("name")
    private String name;

    public BigDecimal getCount() {
        return count;
    }

    public BigDecimal getEventtype_id() {
        return eventtype_id;
    }

    public String getName() {
        return name;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public void setEventtype_id(BigDecimal eventtype_id) {
        this.eventtype_id = eventtype_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
