import models.RestaurantTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestaurantTableTest {

    RestaurantTable table;

    @Before
    public void setUp() throws Exception {
        table = new RestaurantTable(1, 4);
    }

    @Test
    public void hasNumber() {
        assertEquals(1, table.getTableNumber());
    }

    @Test
    public void hasCapacity() {
        assertEquals(4, table.getCapacity());
    }
}
