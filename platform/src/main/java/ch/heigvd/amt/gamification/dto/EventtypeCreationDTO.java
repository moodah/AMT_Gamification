package ch.heigvd.amt.gamification.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * EventDTO
 */
public class EventtypeCreationDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("points")
    private BigDecimal points;

    private BigDecimal applicationId;

    public BigDecimal getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(BigDecimal applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }
}

