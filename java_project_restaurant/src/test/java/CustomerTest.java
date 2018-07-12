import models.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Matt", "Bryce", 200);
    }

    @Test
    public void hasFirstName() {
        assertEquals("Matt", customer.getFirstName());
    }

    @Test
    public void hasLastName() {
        assertEquals("Bryce", customer.getLastName());
    }

    @Test
    public void hasBudget() {
        assertEquals(200, customer.getBudget(), 0.01);
    }
}
