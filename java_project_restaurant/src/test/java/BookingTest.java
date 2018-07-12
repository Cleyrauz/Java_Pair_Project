import models.Booking;
import models.Customer;
import models.Restaurant;
import models.RestaurantTable;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookingTest {
    Booking booking;
    RestaurantTable table1;
    RestaurantTable table2;
    RestaurantTable table3;
    RestaurantTable table4;
    Restaurant restaurant;

    ArrayList<Customer> customers;
    Customer customer1;
    Customer customer2;
    Customer customer3;
    Customer customer4;

    Date dateTime;


    @Before
    public void setUp() throws Exception {

        restaurant = new Restaurant("Del Arepas");
        table1 = new RestaurantTable(1, 4, restaurant);
        table2 = new RestaurantTable(2, 2, restaurant);
        table3 = new RestaurantTable(3, 2, restaurant);
        table4 = new RestaurantTable(4, 6, restaurant);

        customers = new ArrayList<Customer>();
        customer1 = new Customer("Matthew", "Bryce", 100);
        customer2 = new Customer("Cleyra", "Uzcategui", 200);
        customer3 = new Customer("Angelina", "Blyth", 300);
        customer4 = new Customer("Steven", "Bonner", 400);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);

        dateTime = new Date(2018, 2,4, 21,0);

        booking = new Booking(restaurant, customers, table1, dateTime, 120);
    }

    @Test
    public void hasRestaurant() {
        assertEquals("Del Arepas", booking.getRestaurant().getName());
    }

    @Test
    public void hasCustomers() {
        assertEquals(4, booking.getCustomers().size());
    }

    @Test
    public void hasTable() {
        assertEquals(1, booking.getRestaurantTable().getTableNumber());
    }

    @Test
    public void hasDate() {
        assertEquals(2018, booking.getDateTime().getYear());
    }

    @Test
    public void hasLength() {
        assertEquals(120, booking.getBookingLength());
    }
}
