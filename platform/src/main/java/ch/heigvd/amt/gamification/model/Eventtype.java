package ch.heigvd.amt.gamification.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import ch.heigvd.amt.gamification.dto.EventtypeCreationDTO;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Eventtype
 */
@javax.annotation.Generated(value = "class ch.heigvd.amt.gamification.codegen.languages.SpringCodegen", date = "2016-12-18T13:30:19.867Z")

@Entity
@Table(name = "eventtype")
public class Eventtype   {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal points;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eventtype")
    private List<Event> events = new LinkedList<>();

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eventtype")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<Achievement> achievements = new LinkedList<>();

    public Eventtype() {
    }

    public Eventtype(String name, BigDecimal points, Application application) {
        this.name = name;
        this.points = points;
        this.application = application;
    }

    public Eventtype(EventtypeCreationDTO event) {
        this.name = event.getName();
        this.points = event.getPoints();
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Application getApplication() {
        return application;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Eventtype eventtype = (Eventtype) o;
        return Objects.equals(this.name, eventtype.name) &&
                Objects.equals(this.application, eventtype.application);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Eventtype {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
