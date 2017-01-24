package ch.heigvd.amt.gamification.dto;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * UserDTO
 */
public class UserPresentationDTO {

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("points")
    private long points;

    @JsonProperty("level")
    private LevelPresentationDTO level;

    @JsonProperty("badges")
    private List<BadgePresentationDTO> badges = new ArrayList<BadgePresentationDTO>();

    public UserPresentationDTO(long userId, long points, LevelPresentationDTO level, List<BadgePresentationDTO> badges) {
        this.userId = userId;
        this.points = points;
        this.level = level;
        this.badges = badges;
    }

    public long getUserId() {
        return userId;
    }

    public long getPoints() {
        return points;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setPoints(long points) {
        this.points = points;
    }
}
