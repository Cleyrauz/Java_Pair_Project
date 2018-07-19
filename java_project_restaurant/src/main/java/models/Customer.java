package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private List<Booking> bookings;
    private double budget;
//    private int bookings_size;

    public Customer(){
    }

    public Customer(String firstName, String lastName, double budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.budget = budget;
        this.bookings = new ArrayList<>();
//        this.bookings_size = 0;
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

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name ="last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="customer", fetch = FetchType.EAGER)
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    @Column(name = "budget")
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

//    @Column(name = "bookings_size")
//    public int getBookings_size() {
//        return bookings_size;
//    }
//
//    public void setBookings_size(int size) {
//        this.bookings_size = size;
//    }



}
