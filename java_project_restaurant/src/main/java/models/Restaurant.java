package models;

import java.util.List;

public class Restaurant {

    private String name;
    private List<Booking> bookings;
    private List<RestaurantTable> restaurantTables;

    public Restaurant() {
    }

    public Restaurant(String name, List<RestaurantTable> restaurantTables) {
        this.name = name;
        this.restaurantTables = restaurantTables;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<RestaurantTable> getRestaurantTables() {
        return restaurantTables;
    }

    public void setRestaurantTables(List<RestaurantTable> restaurantTables) {
        this.restaurantTables = restaurantTables;
    }
}
