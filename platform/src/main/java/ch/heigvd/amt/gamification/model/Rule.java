package ch.heigvd.amt.gamification.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ch.heigvd.amt.gamification.model.Achievement;
import ch.heigvd.amt.gamification.model.Badge;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Rule
 */
@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Entity
@Table(name = "rule")
public class Rule   {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty("name")
    @Type(type = "text")
    @Column(nullable = false)
    private String name;

    //@JsonProperty("achievements")
    // TODO
    //private List<Achievement> achievements = new ArrayList<Achievement>();

    @JsonProperty("badge")
    @ManyToOne
    @JoinColumn(name = "badge_id", nullable = false)
    private Badge badge;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    public Rule name(String name) {
        this.name = name;
        return this;
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

//    public Rule achievements(List<Achievement> achievements) {
//        this.achievements = achievements;
//        return this;
//    }
//
//    public Rule addAchievementsItem(Achievement achievementsItem) {
//        this.achievements.add(achievementsItem);
//        return this;
//    }

    /**
     * Get achievements
     * @return achievements
     **/
//    @ApiModelProperty(value = "")
//    public List<Achievement> getAchievements() {
//        return achievements;
//    }
//
//    public void setAchievements(List<Achievement> achievements) {
//        this.achievements = achievements;
//    }

    public Rule badge(Badge badge) {
        this.badge = badge;
        return this;
    }

    /**
     * Get badge
     * @return badge
     **/
    @ApiModelProperty(value = "")
    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rule rule = (Rule) o;
        return Objects.equals(this.name, rule.name) &&
                Objects.equals(this.application, rule.application);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, achievements, badge);
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Rule {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
//        sb.append("    achievements: ").append(toIndentedString(achievements)).append("\n");
        sb.append("    badge: ").append(toIndentedString(badge)).append("\n");
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

