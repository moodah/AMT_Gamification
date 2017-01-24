package ch.heigvd.amt.gamification.dto;

import ch.heigvd.amt.gamification.model.Application;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ApplicationPresentationDTO
 */
public class ApplicationPresentationDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    public ApplicationPresentationDTO(Application application) {
        this.id = application.getId();
        this.name = application.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
