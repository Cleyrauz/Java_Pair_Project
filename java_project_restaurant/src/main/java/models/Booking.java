package models;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="bookings")
public class Booking {

    private int id;
    private Customer customer;
    private RestaurantTable restaurantTable;
//    private Calendar dateTime;
//    private int bookLength;

    public Booking(){

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

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="restaurantTable_id", nullable = false)
    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }
}
