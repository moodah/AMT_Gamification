package ch.heigvd.amt.gamification.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.Level;
import ch.heigvd.amt.gamification.model.Username;
import java.util.ArrayList;
import java.util.List;

/**
 * Reputation
 */
@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-13T18:36:02.067Z")

public class Reputation   {
  @JsonProperty("user")
  private Username user = null;

  @JsonProperty("level")
  private Level level = null;

  @JsonProperty("badges")
  private List<Badge> badges = new ArrayList<Badge>();

  public Reputation user(Username user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")
  public Username getUser() {
    return user;
  }

  public void setUser(Username user) {
    this.user = user;
  }

  public Reputation level(Level level) {
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

  public Reputation badges(List<Badge> badges) {
    this.badges = badges;
    return this;
  }

  public Reputation addBadgesItem(Badge badgesItem) {
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
    Reputation reputation = (Reputation) o;
    return Objects.equals(this.user, reputation.user) &&
        Objects.equals(this.level, reputation.level) &&
        Objects.equals(this.badges, reputation.badges);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, level, badges);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reputation {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

