package ch.heigvd.amt.gamification.dto;

import ch.heigvd.amt.gamification.model.Level;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private long points;

    public LevelPresentationDTO(long id, String name, long points) {
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

    public long getPoints() {
        return points;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(long points) {
        this.points = points;
    }
}
