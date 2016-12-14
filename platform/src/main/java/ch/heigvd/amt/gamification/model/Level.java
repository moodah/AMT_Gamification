package ch.heigvd.amt.gamification.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * Level
 */
@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-13T18:36:02.067Z")

public class Level   {
  @JsonProperty("number")
  private BigDecimal number = null;

  @JsonProperty("points")
  private BigDecimal points = null;

  public Level number(BigDecimal number) {
    this.number = number;
    return this;
  }

   /**
   * Get number
   * @return number
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getNumber() {
    return number;
  }

  public void setNumber(BigDecimal number) {
    this.number = number;
  }

  public Level points(BigDecimal points) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Level level = (Level) o;
    return Objects.equals(this.number, level.number) &&
        Objects.equals(this.points, level.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, points);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Level {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
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

