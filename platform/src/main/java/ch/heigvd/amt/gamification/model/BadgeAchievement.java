package ch.heigvd.amt.gamification.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * BadgeAchievement
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-01-24T12:55:51.106Z")

public class BadgeAchievement   {
  @JsonProperty("achievement_id")
  private BigDecimal achievementId = null;

  @JsonProperty("badge_id")
  private BigDecimal badgeId = null;

  public BadgeAchievement achievementId(BigDecimal achievementId) {
    this.achievementId = achievementId;
    return this;
  }

   /**
   * Get achievementId
   * @return achievementId
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getAchievementId() {
    return achievementId;
  }

  public void setAchievementId(BigDecimal achievementId) {
    this.achievementId = achievementId;
  }

  public BadgeAchievement badgeId(BigDecimal badgeId) {
    this.badgeId = badgeId;
    return this;
  }

   /**
   * Get badgeId
   * @return badgeId
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getBadgeId() {
    return badgeId;
  }

  public void setBadgeId(BigDecimal badgeId) {
    this.badgeId = badgeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BadgeAchievement badgeAchievement = (BadgeAchievement) o;
    return Objects.equals(this.achievementId, badgeAchievement.achievementId) &&
        Objects.equals(this.badgeId, badgeAchievement.badgeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(achievementId, badgeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadgeAchievement {\n");
    
    sb.append("    achievementId: ").append(toIndentedString(achievementId)).append("\n");
    sb.append("    badgeId: ").append(toIndentedString(badgeId)).append("\n");
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

