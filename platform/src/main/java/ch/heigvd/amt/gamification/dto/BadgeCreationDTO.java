package ch.heigvd.amt.gamification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    private List<Long> achievements;

    public BadgeCreationDTO() {
    }

    public BadgeCreationDTO(String name, String description, List<Long> achievements) {
        this.name = name;
        this.description = description;
        this.achievements = achievements;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Long> getAchievements() {
        return achievements;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAchievements(List<Long> achievements) {
        this.achievements = achievements;
    }
}
