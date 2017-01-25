package ch.heigvd.amt.gamification.model;

import java.util.Objects;

import ch.heigvd.amt.gamification.dto.LevelCreationDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Level
 */
@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Entity
@Table(name = "level")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("name")
    @NotNull
    @Column(length = 128, nullable = false)
    private String name;

    @JsonProperty("points")
    @NotNull
    @Column(nullable = false)
    private long points;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    public Level() {
    }

    public Level name(String name) {
        this.name = name;
        return this;
    }

    public Level (LevelCreationDTO level) {
        this.name = level.getName();
        this.points = level.getPoints();
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    /**
     * Get name
     * @return name
     **/
    @ApiModelProperty(value = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level points(long points) {
        this.points = points;
        return this;
    }

    /**
     * Get points
     * @return points
     **/
    @ApiModelProperty(value = "")
    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Level level = (Level) o;
        return Objects.equals(this.name, level.name) &&
               Objects.equals(this.application, level.application);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Level {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    points: ").append(toIndentedString(points)).append("\n");
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
