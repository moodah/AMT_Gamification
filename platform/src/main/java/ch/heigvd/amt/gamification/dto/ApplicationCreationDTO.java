package ch.heigvd.amt.gamification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ApplicationDTO
 */
public class ApplicationDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("password")
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

