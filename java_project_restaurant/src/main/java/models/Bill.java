package models;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private List<Item> items;
    private Booking booking;

    public Bill(){
    }

    public Bill(ArrayList<Item> items, Booking booking) {
        this.items = items;
        this.booking = booking;
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

