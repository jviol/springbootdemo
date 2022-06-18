package jviol.springbootdemo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Instant feedingTime;
    private String type;
    private Integer milliLiters;

    private Set<Supplement> supplements;

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

    public Integer getMilliLiters() {
        return milliLiters;
    }

    public void setMilliLiters(Integer milliLiters) {
        this.milliLiters = milliLiters;
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
