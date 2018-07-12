import db.DBHelper;
import models.*;

import java.util.ArrayList;
import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        DBHelper.deleteAll(RestaurantTable.class);
        DBHelper.deleteAll(Restaurant.class);
        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(Item.class);
        DBHelper.deleteAll(Booking.class);

        Restaurant restaurant = new Restaurant("Del Arepas");
        DBHelper.save(restaurant);

        Customer customer = new Customer("Matthew", "Bryce", 100.50);
        DBHelper.save(customer);

        RestaurantTable restaurantTable = new RestaurantTable(1, 6, restaurant);
        DBHelper.save(restaurantTable);

        Item item = new Item(ItemType.FAJITAS);
        DBHelper.save(item);

        Date date = new Date(2018, 10, 2, 17, 10);

        Booking booking = new Booking(restaurant, restaurantTable, date, 120);
        DBHelper.save(booking);

        Bill bill = new Bill(booking);
        DBHelper.save(bill);

        bill.addItem(item);
        DBHelper.save(item);
    }
}
