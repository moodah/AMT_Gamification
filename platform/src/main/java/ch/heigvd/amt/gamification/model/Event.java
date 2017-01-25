package ch.heigvd.amt.gamification.model;

import java.util.Date;
import java.util.Objects;

import ch.heigvd.amt.gamification.configuration.AppConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Event
 */
@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Entity
@Table(name = "event")
public class Event   {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = AppConfig.MAX_APP_NAME_LENGTH, nullable = false)
    private Date timestamp;

    @JsonProperty("eventtype")
    @ManyToOne
    @JoinColumn(name = "eventtype_id", nullable = false)
    private Eventtype eventtype;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @Column(nullable = false)
    private long userId;

    public Event() {
    }

    public Event(Date timestamp, long userId, Eventtype eventtype, Application application) {
        this.timestamp = timestamp;
        this.userId = userId;
        this.eventtype = eventtype;
        this.application = application;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Get timestamp
     * @return timestamp
     **/
    @ApiModelProperty(value = "")
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public long getId() {
        return id;
    }

    public Application getApplication() {
        return application;
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
                Objects.equals(this.eventtype, event.eventtype) &&
                Objects.equals(this.application, event.application);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, eventtype);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Event {\n");

        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

