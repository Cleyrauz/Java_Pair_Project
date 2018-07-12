package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Bill {

    private int id;
    private ArrayList<Item> items;
    private Booking booking;

    public Bill(){
    }

    public Bill(ArrayList<Item> items, Booking booking) {
        this.items = items;
        this.booking = booking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}

