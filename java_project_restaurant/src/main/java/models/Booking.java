package models;

import java.util.ArrayList;
import java.util.Calendar;

public class Booking {

    private Restaurant restaurant;
    private ArrayList<Customer> customers;
    private RestaurantTable restaurantTable;
    private Calendar dateTime;
    private int bookingLength;

    public Booking(){
    }

    public Booking(Restaurant restaurant, ArrayList<Customer> customers, RestaurantTable restaurantTable, Calendar dateTime, int bookingLength) {
        this.restaurant = restaurant;
        this.customers = customers;
        this.restaurantTable = restaurantTable;
        this.dateTime = dateTime;
        this.bookingLength = bookingLength;
    }

    public ArrayList<Customer> getCustomer() {
        return customers;
    }

    public void setCustomer(ArrayList<Customer> customers) {
        this.customers = customers;
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
