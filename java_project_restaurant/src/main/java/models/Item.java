package models;

import java.util.List;

public class Item {

    private ItemType itemType;
    private List<Bill> bills;

    public Item(){
    }

    public Item(ItemType type) {
        this.itemType = type;
    }

    public String getName() {
        return itemType.getName();
    }

    public double getPrice() {
        return itemType.getPrice();
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
