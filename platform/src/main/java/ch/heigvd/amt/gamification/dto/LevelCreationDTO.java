package ch.heigvd.amt.gamification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * Level
 */
public class LevelCreationDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("points")
    private BigDecimal points;

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
