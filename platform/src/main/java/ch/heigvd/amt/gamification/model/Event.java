package ch.heigvd.amt.gamification.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ch.heigvd.amt.gamification.model.Eventtype;
import ch.heigvd.amt.gamification.model.User;
import org.joda.time.DateTime;

/**
 * Event
 */
@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-16T15:16:07.537Z")

public class Event   {
  @JsonProperty("timestamp")
  private DateTime timestamp = null;

  @JsonProperty("user")
  private User user = null;

  @JsonProperty("eventtype")
  private Eventtype eventtype = null;

  public Event timestamp(DateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(value = "")
  public DateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(DateTime timestamp) {
    this.timestamp = timestamp;
  }

  public Event user(User user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Event eventtype(Eventtype eventtype) {
    this.eventtype = eventtype;
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.timestamp, event.timestamp) &&
        Objects.equals(this.user, event.user) &&
        Objects.equals(this.eventtype, event.eventtype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, user, eventtype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

