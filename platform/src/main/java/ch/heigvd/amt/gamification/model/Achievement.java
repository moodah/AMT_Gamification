package ch.heigvd.amt.gamification.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Achievement
 */
@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Entity
@Table(name = "achievement")
public class Achievement   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int count;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @ManyToOne
    private Eventtype eventtype;

    @Column
    private String name;

    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(name="badge_achievement", joinColumns={@JoinColumn(name="achievement_id")}, inverseJoinColumns={@JoinColumn(name="badge_id")})
    private List<Badge> badges = new ArrayList<Badge>();

    public Achievement(int count, Application application, Eventtype eventtype, String name) {
        this.count = count;
        this.application = application;
        this.eventtype = eventtype;
        this.name = name;
    }

    public Achievement count(int count) {
        this.count = count;
        return this;
    }

    @ApiModelProperty(value = "")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get count
     * @return count
     **/
    @ApiModelProperty(value = "")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Achievement eventType(Eventtype eventType) {
        this.eventtype = eventType;
        return this;
    }

    /**
     * Get eventtype
     * @return eventtype
     **/
    @ApiModelProperty(value = "")
    public Eventtype getEventtype() {
        return eventtype;
    }

    public void setEventtype(Eventtype eventtype) {
        this.eventtype = eventtype;
    }

    @ApiModelProperty(value = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Achievement achievement = (Achievement) o;
        return Objects.equals(this.count, achievement.count) &&
                Objects.equals(this.eventtype, achievement.eventtype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, eventtype);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Achievement {\n");

        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    eventtype: ").append(toIndentedString(eventtype)).append("\n");
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