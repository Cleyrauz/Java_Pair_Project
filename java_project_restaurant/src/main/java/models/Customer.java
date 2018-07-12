package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private int totalBooked;
    private List<Booking> bookings;

    public Customer(){

    }

    public Customer(String firstName, String lastName, int totalBooked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalBooked = totalBooked;
        this.bookings = new ArrayList<Booking>();
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

    @Column(name="firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="totalBooked")
    public int getTotalBooked() {
        return totalBooked;
    }

    public void setTotalBooked(int totalBooked) {
        this.totalBooked = totalBooked;
    }

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }
}
