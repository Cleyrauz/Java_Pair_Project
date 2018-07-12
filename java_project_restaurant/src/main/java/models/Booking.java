package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="bookings")
public class Booking {

    private int id;
    private Restaurant restaurant;
    private List<Customer> customers;
    private RestaurantTable restaurantTable;
    private Date dateTime;
    private int bookingLength;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Bill bill;

    public Booking(){
    }

    public Booking(Restaurant restaurant, RestaurantTable restaurantTable, Date dateTime, int bookingLength) {
        this.restaurant = restaurant;
        this.customers = new ArrayList<Customer>();
        this.restaurantTable = restaurantTable;
        this.dateTime = dateTime;
        this.bookingLength = bookingLength;
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    @Column(name="dataTime")
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name="bookingLength")
    public int getBookingLength() {
        return bookingLength;
    }

    public void setBookingLength(int bookingLength) {
        this.bookingLength = bookingLength;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
