import models.Bill;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BillTest {

    Bill bill;

    @Before
    public void setUp() throws Exception {
        bill = new Bill(100);
    }

    @Test
    public void hasAmount() {
        assertEquals(100, bill.getTotalPrice(), 0.01);
    }
}
