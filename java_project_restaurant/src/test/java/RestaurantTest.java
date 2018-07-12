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

    @Before
    public void setUp() throws Exception {

        restaurant = new Restaurant("Del Arepas");
        table1 = new RestaurantTable(1, 4, restaurant);
        table2 = new RestaurantTable(2, 2, restaurant);
        table3 = new RestaurantTable(3, 2, restaurant);
        table4 = new RestaurantTable(4, 6, restaurant);

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
