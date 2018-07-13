package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tables")
public class RestaurantTable {

    private int id;
    private int tableNumber;
    private int capacity;
    private List<Booking> bookings;
    private Restaurant restaurant;

    public RestaurantTable() {
    }

    public RestaurantTable(int tableNumber, int capacity, Restaurant restaurant) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.bookings = new ArrayList<>();
        this.restaurant = restaurant;
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

    @Column(name = "table_number")
    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @OneToMany(mappedBy = "restaurantTable", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBoooking(Booking booking){
        this.bookings.add(booking);
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
