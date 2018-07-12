package models;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bills")
public class Bill {

    private int id;
    private List<Items> items;
    private int totalPrice;

    public Bill(){

    }

    public Bill(int totalPrice) {
        this.items = new ArrayList<Items>();
        this.totalPrice = totalPrice;
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

    @Column(name="totalPrice")
    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name="items_bill",
            joinColumns = {@JoinColumn(name="bill_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="items_id", nullable =false, updatable = false)})
    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public void addItemsToBill(Items items){
        this.items.add(items);
    }
}

