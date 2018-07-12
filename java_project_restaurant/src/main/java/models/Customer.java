package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private int totalBooked;
    private Table table;

    public Customer(){

    }

    public Customer(String firstName, String lastName, int totalBooked, Table table) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalBooked = totalBooked;
        this.table = table;
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

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name="customer_table",
    joinColumns = {@JoinColumn(name="customer_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name="table_id", nullable = false, updatable = false)})
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
