package ch.heigvd.amt.gamification.dto;

import ch.heigvd.amt.gamification.model.Eventtype;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

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
    private BigDecimal points;

    @JsonProperty("application_id")
    private long application_id;

    public EventtypePresentationDTO(Eventtype eventtype) {
        this.id = eventtype.getId();
        this.name = eventtype.getName();
        this.points = eventtype.getPoints();
        this.application_id = eventtype.getApplication().getId();
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

    public long getApplication_id() {
        return application_id;
    }

    public void setApplication_id(long application_id) {
        this.application_id = application_id;
    }
}
