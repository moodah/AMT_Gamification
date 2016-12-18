package ch.heigvd.amt.gamification.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * User
 */
@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

public class User   {
  @JsonProperty("username")
  private String username = null;

  @JsonProperty("points")
  private BigDecimal points = null;

  @JsonProperty("level")
  private Level level = null;

  @JsonProperty("badges")
  private List<Badge> badges = new ArrayList<Badge>();

  public User username(String username) {
    this.username = username;
    return this;
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
            Objects.equals(this.points, user.points) &&
            Objects.equals(this.level, user.level) &&
            Objects.equals(this.badges, user.badges);
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
