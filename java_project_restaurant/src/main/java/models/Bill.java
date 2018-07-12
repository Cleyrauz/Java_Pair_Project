package models;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private List<Item> items;
    private double totalPrice;

    public Bill(){

    }

    public Bill(double totalPrice) {
        this.items = new ArrayList<Item>();
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems() {
        this.items = items;
    }

    public void addItemsToBill(Item item){
        this.items.add(item);
    }
}

