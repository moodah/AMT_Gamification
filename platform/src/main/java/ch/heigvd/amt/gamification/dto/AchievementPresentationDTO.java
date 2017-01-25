package ch.heigvd.amt.gamification.dto;

import ch.heigvd.amt.gamification.model.Achievement;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AchievementPresentationDTO
 */
public class AchievementPresentationDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("count")
    private long count;

    @JsonProperty("eventtype")
    private EventtypePresentationDTO eventtypePresentationDTO;

    public AchievementPresentationDTO(long id, String name, long count, EventtypePresentationDTO eventtypePresentationDTO) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.eventtypePresentationDTO = eventtypePresentationDTO;
    }

    public AchievementPresentationDTO(Achievement achievement) {
        id = achievement.getId();
        name = achievement.getName();
        count = achievement.getCount();
        eventtypePresentationDTO = new EventtypePresentationDTO(achievement.getEventtype());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCount() {
        return count;
    }

    public EventtypePresentationDTO getEventtypePresentationDTO() {
        return eventtypePresentationDTO;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setEventtypePresentationDTO(EventtypePresentationDTO eventtypePresentationDTO) {
        this.eventtypePresentationDTO = eventtypePresentationDTO;
    }
}
