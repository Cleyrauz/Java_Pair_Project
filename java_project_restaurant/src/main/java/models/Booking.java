package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    private int id;
    private Restaurant restaurant;
    private List<Customer> customers;
    private RestaurantTable restaurantTable;
    private Date dateTime;
    private int bookingLength;


    private Bill bill;

    public Booking(){
    }

    public Booking(Restaurant restaurant, RestaurantTable restaurantTable, Date dateTime, int bookingLength) {
        this.restaurant = restaurant;
        this.customers = new ArrayList<>();
        this.restaurantTable = restaurantTable;
        this.dateTime = dateTime;
        this.bookingLength = bookingLength;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="booking_customer",
            joinColumns = {@JoinColumn(name="booking_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="customer_id", nullable =false, updatable = false)})
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_table_id")
    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    @Column(name="date_time")
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "booking_length")
    public int getBookingLength() {
        return bookingLength;
    }

    public void setBookingLength(int bookingLength) {
        this.bookingLength = bookingLength;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @OneToOne(mappedBy = "booking",
        fetch = FetchType.LAZY)
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }


}
