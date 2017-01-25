package ch.heigvd.amt.gamification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * EventDTO
 */
public class EventtypeCreationDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("points")
    private Long points;

    @JsonProperty("application_id")
    private Long applicationId;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public Long getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
}

