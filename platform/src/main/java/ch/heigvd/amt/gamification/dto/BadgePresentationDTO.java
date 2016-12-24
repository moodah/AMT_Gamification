package ch.heigvd.amt.gamification.dto;

import ch.heigvd.amt.gamification.model.Badge;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    public BadgePresentationDTO(Badge badge) {
        this.id = badge.getId();
        this.name = badge.getName();
        this.description = badge.getDescription();
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
}

