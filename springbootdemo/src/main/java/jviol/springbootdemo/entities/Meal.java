package jviol.springbootdemo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Meal")
public class Meal {

    public record Dto(Instant feedingTime, String type, int milliliters,
                      Set<Supplement.Dto> supplements) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Instant feedingTime;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Integer milliliters;

    @OneToMany
    @JoinColumn(name = "mealId")
    private Set<Supplement> supplements = new HashSet<>();

    public Instant getFeedingTime() {
        return feedingTime;
    }

    public void setFeedingTime(Instant feedingTime) {
        this.feedingTime = feedingTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(Integer milliliters) {
        this.milliliters = milliliters;
    }

    public Long getId() {
        return id;
    }

    public Set<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(Set<Supplement> supplements) {
        this.supplements = supplements;
    }


}
