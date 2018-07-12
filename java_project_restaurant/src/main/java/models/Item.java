package models;

import java.util.ArrayList;
import java.util.List;

public class Item {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
