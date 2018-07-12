package models;

import javax.persistence.*;
import java.util.List;


public class Item {

    private int id;
    private ItemType itemType;
    private List<Bill> bills;

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

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
