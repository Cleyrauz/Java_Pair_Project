package models;

import java.util.List;

public class Bill {

    private int id;
    private List<Item> items;
    private Booking booking;

    public Bill(){
    }

    public Bill(List<Item> items, Booking booking) {
        this.items = items;
        this.booking = booking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}

