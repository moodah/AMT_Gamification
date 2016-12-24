package ch.heigvd.amt.gamification.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * EventDTO
 */
public class EventtypeCreationDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private BigDecimal code;

    @JsonProperty("points")
    private BigDecimal points;

    public String getName() {
        return name;
    }

    public BigDecimal getCode() {
        return code;
    }

    public BigDecimal getPoints() {
        return points;
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

