package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    private int id;
    private String name;
    private List<Booking> bookings;
    private List<RestaurantTable> restaurantTables;

    public Restaurant() {
    }

    public Restaurant(String name) {
        this.name = name;
        this.bookings = new ArrayList<>();
        this.restaurantTables = new ArrayList<>();
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    public List<RestaurantTable> getRestaurantTables() {
        return restaurantTables;
    }

    public void setRestaurantTables(List<RestaurantTable> restaurantTables) {
        this.restaurantTables = restaurantTables;
    }

    public void addRestaurantTable(RestaurantTable restaurantTable){
        this.restaurantTables.add(restaurantTable);
    }
}
