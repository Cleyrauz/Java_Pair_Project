package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Bill {

    private int id;
    private List<Item> items;
    private Booking booking;

    public Bill(){
    }

    public Bill(Booking booking) {
        this.booking = booking;
        this.items = new ArrayList<Item>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @OneToOne(mappedBy = "booking")
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}

