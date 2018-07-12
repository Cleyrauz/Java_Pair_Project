import models.Restaurant;
import models.RestaurantTable;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RestaurantTest {

    Restaurant restaurant;
    RestaurantTable table1;
    RestaurantTable table2;
    RestaurantTable table3;
    RestaurantTable table4;
    List<RestaurantTable> tables;

    @Before
    public void setUp() throws Exception {
        tables = new ArrayList<RestaurantTable>();
        table1 = new RestaurantTable(1, 4);
        table2 = new RestaurantTable(2, 2);
        table3 = new RestaurantTable(3, 2);
        table4 = new RestaurantTable(4, 6);
        tables.add(table1);
        tables.add(table2);
        tables.add(table3);
        tables.add(table4);
        restaurant = new Restaurant("Del Arepas", tables);
    }

    @Test
    public void hasName() {
        assertEquals("Del Arepas", restaurant.getName());
    }

    @Test
    public void hasTables() {
        assertEquals(4, restaurant.getRestaurantTables().size());
    }
}
