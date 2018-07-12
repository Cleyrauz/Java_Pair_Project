package models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="items")
public class Item {

    private int id;
    private String name;
    private double price;
    private List<Bill> bills;

    public Item(){

    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.bills = new ArrayList<Bill>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name="items_bill",
            joinColumns = {@JoinColumn(name="item_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="bill_id", nullable =false, updatable = false)})
    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
