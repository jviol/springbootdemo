package jviol.springbootdemo.entities;

import javax.persistence.*;

@Entity
public class Supplement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "quantity_id")
    private Quantity quantity;

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }
}
