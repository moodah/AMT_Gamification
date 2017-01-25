package ch.heigvd.amt.gamification.dto;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty("eventtypesIdAndCount")
    Map<Long, Long> eventtypesAndCount = new HashMap<>();

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

    public LevelPresentationDTO getLevel() {
        return level;
    }

    public List<BadgePresentationDTO> getBadges() {
        return badges;
    }

    public void setLevel(LevelPresentationDTO level) {
        this.level = level;
    }

    public void setBadges(List<BadgePresentationDTO> badges) {
        this.badges = badges;
    }

    public Map<Long, Long> getEventtypesAndCount() {
        return eventtypesAndCount;
    }

    public void setEventtypesAndCount(Map<Long, Long> eventtypesAndCount) {
        this.eventtypesAndCount = eventtypesAndCount;
    }
}
