package ch.heigvd.amt.gamification.dto;

import ch.heigvd.amt.gamification.model.Eventtype;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 22.12.2016
 */
public class EventtypePresentationDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("points")
    private long points;

    public EventtypePresentationDTO(Eventtype eventtype) {
        this.id = eventtype.getId();
        this.name = eventtype.getName();
        this.points = eventtype.getPoints();
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
