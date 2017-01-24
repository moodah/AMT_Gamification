package ch.heigvd.amt.gamification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * RuleDTO
 */
public class RuleCreationDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("achievement")
    private BigDecimal achievement;

    @JsonProperty("eventtype_code")
    private BigDecimal code;

    @JsonProperty("badge_id")
    private long badgeId;

//    @JsonProperty("achievements")
//     TODO
//    private List<Achievement> achievements = new ArrayList<Achievement>();

    @JsonProperty("badge")
    private BadgePresentationDTO badge;

    private ApplicationCreationDTO application;
}

