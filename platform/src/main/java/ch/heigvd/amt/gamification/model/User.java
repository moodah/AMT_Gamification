package ch.heigvd.amt.gamification.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * User
 */
@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Entity
@Table(name = "user")
public class User   {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty("username")
    @Column(length = 255, nullable = false)
    private String username;

    @JsonProperty("points")
    @Column(nullable = false)
    private BigDecimal points;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level = null;

    @ManyToMany
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinTable(name="user_badge", joinColumns={@JoinColumn(name="user_id")}, inverseJoinColumns={@JoinColumn(name="badge_id")})
    private List<Badge> badges = new ArrayList<Badge>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<Event> events = new LinkedList<>();

    public User() {
    }

    public User(String username, Application application, Level level) {
        this.username = username;
        this.application = application;
        this.level = level;
        this.points = new BigDecimal(0);
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public void addPoints(BigDecimal points) {
        this.points = this.points.add(points);
    }
    /**
     * Get username
     * @return username
     **/
    @ApiModelProperty(value = "")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User points(BigDecimal points) {
        this.points = points;
        return this;
    }

    /**
     * Get points
     * @return points
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }

    public User level(Level level) {
        this.level = level;
        return this;
    }

    /**
     * Get level
     * @return level
     **/
    @ApiModelProperty(value = "")
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public User badges(List<Badge> badges) {
        this.badges = badges;
        return this;
    }

    public User addBadgesItem(Badge badgesItem) {
        this.badges.add(badgesItem);
        return this;
    }

    /**
     * Get badges
     * @return badges
     **/
    @ApiModelProperty(value = "")
    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.username, user.username) &&
                Objects.equals(this.application, user.application);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, points, level, badges);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");

        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    points: ").append(toIndentedString(points)).append("\n");
        sb.append("    level: ").append(toIndentedString(level)).append("\n");
        sb.append("    badges: ").append(toIndentedString(badges)).append("\n");
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
