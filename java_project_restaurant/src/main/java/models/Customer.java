package models;

import java.util.List;

public class Customer {

    private String firstName;
    private String lastName;
    private List<Booking> bookings;
    private double budget;

    public Customer(){
    }

    public Customer(String firstName, String lastName, double budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.budget = budget;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
