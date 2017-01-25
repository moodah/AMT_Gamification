package ch.heigvd.amt.gamification.dto;

import ch.heigvd.amt.gamification.model.Badge;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * BadgeDTO
 */
public class BadgePresentationDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("achievements")
    private List<AchievementPresentationDTO> achievementPresentationDTOList = new ArrayList<>();

    public BadgePresentationDTO(Badge badge) {
        this.id = badge.getId();
        this.name = badge.getName();
        this.description = badge.getDescription();
        badge.getAchievements().forEach(achievement -> {
            achievementPresentationDTOList.add(new AchievementPresentationDTO(achievement));
        });
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AchievementPresentationDTO> getAchievementPresentationDTOList() {
        return achievementPresentationDTOList;
    }

    public void setAchievementPresentationDTOList(List<AchievementPresentationDTO> achievementPresentationDTOList) {
        this.achievementPresentationDTOList = achievementPresentationDTOList;
    }
}

