package ch.heigvd.amt.gamification.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Badge
 */
@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-16T15:16:07.537Z")

@Entity
@Table(name = "badge")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("name")
    @Column(length = 255, nullable = false, unique = true)
    private String name;

    @JsonProperty("description")
    @Type(type = "text")
    @Column(nullable = false)
    private String description;

    @ManyToMany
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinTable(name="user_badge", joinColumns={@JoinColumn(name="badge_id")}, inverseJoinColumns={@JoinColumn(name="user_id")})
    Set<User> users = new HashSet<>(); // users are unique for a given badge

    @ManyToMany
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinTable(name="badge_achievement", joinColumns={@JoinColumn(name="badge_id")}, inverseJoinColumns={@JoinColumn(name="achievement_id")})
    Set<Achievement> achievements = new HashSet<>(); // achivements are unique for a given badge

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    public Badge name(String name) {
        this.name = name;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(value = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Badge description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @ApiModelProperty(value = "")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Badge badge = (Badge) o;
        return Objects.equals(this.name, badge.name) &&
                Objects.equals(this.application, badge.application);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Badge {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

