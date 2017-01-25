package ch.heigvd.amt.gamification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * BadgeCreationDTO
 */
public class BadgeCreationDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("achievements")
    private List<Long> achievementsIds = new ArrayList<>();

    public BadgeCreationDTO() {
    }

    public BadgeCreationDTO(String name, String description, List<Long> achievementsIds) {
        this.name = name;
        this.description = description;
        this.achievementsIds = achievementsIds;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Long> getAchievementsIds() {
        return achievementsIds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAchievementsIds(List<Long> achievementsIds) {
        this.achievementsIds = achievementsIds;
    }
}
