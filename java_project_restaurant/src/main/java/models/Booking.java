package models;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="bookings")
public class Booking {

//    Calendar cal = Calendar.getInstance(); // creates calendar
//        cal.setTime(new Date()); // sets calendar time/date
//        cal.add(Calendar.HOUR_OF_DAY, 1); // adds one hour
//        cal.getTime();

    private int id;
    private Restaurant restaurant;
    private Customer customer;
    private RestaurantTable restaurantTable;
    private Calendar dateTime;
    private int bookingLength;

    public Booking(){
    }

    public Booking(Restaurant restaurant, Customer customer, RestaurantTable restaurantTable, Calendar dateTime, int bookingLength) {
        this.restaurant = restaurant;
        this.customer = customer;
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

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="restaurant_table_id", nullable = false)
    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    @Column(name = "dateTime")
    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "bookingLength")
    public int getBookingLength() {
        return bookingLength;
    }

    public void setBookingLength(int bookingLength) {
        this.bookingLength = bookingLength;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
