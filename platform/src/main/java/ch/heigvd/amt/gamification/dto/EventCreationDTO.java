package ch.heigvd.amt.gamification.dto;

import java.util.LinkedList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * EventtypeDTO
 */
public class EventCreationDTO {

    @JsonProperty("username")
    private String username;

    @JsonProperty("code_event")
    private BigDecimal codeEvent;

    public String getUsername() {
        return username;
    }

    public BigDecimal getCodeEvent() {
        return codeEvent;
    }
}
