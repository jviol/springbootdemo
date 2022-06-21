package jviol.springbootdemo.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "Meal")
public class Meal {

    public record Dto(String babyName, Instant feedingTime, String type, int milliliters,
                      List<Supplement.Dto> supplements) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private Baby baby;

    @Column(nullable = false)
    private Instant feedingTime;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Integer milliliters;

    @OneToMany
    @JoinColumn(name = "meal_id")
    private List<Supplement> supplements;

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

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

    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }


}
