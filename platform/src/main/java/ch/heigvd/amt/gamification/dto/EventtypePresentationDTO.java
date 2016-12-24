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

    @JsonProperty("code")
    private BigDecimal code;

    @JsonProperty("points")
    private BigDecimal points;

    public EventtypePresentationDTO(Eventtype eventtype) {
        this.id = eventtype.getId();
        this.name = eventtype.getName();
        this.code = eventtype.getCode();
        this.points = eventtype.getPoints();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCode() {
        return code;
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

    public void setCode(BigDecimal code) {
        this.code = code;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }
}
