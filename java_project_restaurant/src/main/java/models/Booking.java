package models;

import java.util.Calendar;

public class Booking {

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

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
}
