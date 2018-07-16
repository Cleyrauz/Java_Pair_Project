package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bills")
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill", fetch = FetchType.EAGER, orphanRemoval = true)
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @OneToOne
    @JoinColumn(name = "booking_id")
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}

