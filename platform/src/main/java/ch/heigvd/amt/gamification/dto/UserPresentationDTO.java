package ch.heigvd.amt.gamification.dto;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * UserDTO
 */
public class UserPresentationDTO {

    @JsonProperty("username")
    private String username;

    @JsonProperty("points")
    private BigDecimal points;

    @JsonProperty("level")
    private LevelPresentationDTO level;

    @JsonProperty("badges")
    private List<BadgePresentationDTO> badges = new ArrayList<BadgePresentationDTO>();

    public UserPresentationDTO(String username, BigDecimal points, LevelPresentationDTO level, List<BadgePresentationDTO> badges) {
        this.username = username;
        this.points = points;
        this.level = level;
        this.badges = badges;
    }
}
