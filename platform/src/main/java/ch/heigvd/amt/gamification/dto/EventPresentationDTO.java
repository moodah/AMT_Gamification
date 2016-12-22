package ch.heigvd.amt.gamification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 22.12.2016
 */
public class EventPresentationDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private int code;

    @JsonProperty("points")
    private BigDecimal points;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
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

    public void setCode(int code) {
        this.code = code;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }
}
