package ch.heigvd.amt.gamification.dto;

import ch.heigvd.amt.gamification.model.Level;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 22.12.2016
 */
public class LevelPresentationDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("points")
    private BigDecimal points;

    public LevelPresentationDTO(long id, String name, BigDecimal points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public LevelPresentationDTO(Level level) {
        this.id = level.getId();
        this.name = level.getName();
        this.points = level.getPoints();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }
}
