package models;

import javax.persistence.*;
import java.util.List;


public class Item {

    private int id;
    private ItemType itemType;
    private Bill bill;

    public Item(){
    }


    public Item(ItemType type) {
        this.itemType = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
