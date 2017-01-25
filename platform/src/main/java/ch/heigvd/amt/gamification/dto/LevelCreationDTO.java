package ch.heigvd.amt.gamification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Level
 */
public class LevelCreationDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("points")
    private Long points;

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
