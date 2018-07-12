import db.DBHelper;
import models.*;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        DBHelper.deleteAll(Restaurant.class);

        Restaurant restaurant = new Restaurant("Del Arepas");
        DBHelper.save(restaurant);

        Customer customer = new Customer("Matthew", "Bryce", 100.50);
        DBHelper.save(customer);

        RestaurantTable restaurantTable = new RestaurantTable(1, 6, restaurant);
        DBHelper.save(restaurantTable);
    }
}
