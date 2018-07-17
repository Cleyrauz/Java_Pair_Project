package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    private int id;
    private ItemType itemType;
    private Bill bill;

    public Item(){
    }


    public Item(ItemType type) {
        this.itemType = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Enumerated(value = EnumType.STRING)
    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @ManyToOne
    @JoinColumn(name = "bill_id")
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

}
