package db;

import models.*;

import java.text.ParseException;
import java.util.Date;

public class Seeds {

    public static void seedData() throws ParseException {

        DBHelper.deleteAll(Item.class);
        DBHelper.deleteAll(Bill.class);
        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(Booking.class);
        DBHelper.deleteAll(RestaurantTable.class);
        DBHelper.deleteAll(Restaurant.class);

        Restaurant restaurant = new Restaurant("Del Arepas");
        DBHelper.save(restaurant);

        Restaurant restaurant2 = new Restaurant("Del Pie");
        DBHelper.save(restaurant2);

        Customer customer1 = new Customer("Matthew", "Bryce", 100.50);
        Customer customer2 = new Customer("Cleyra", "Uzcategui", 200.80);
        Customer customer3 = new Customer("Adri", "Florence", 90.20);
        Customer customer4 = new Customer("Jose", "Calderon", 200);
        DBHelper.save(customer1);
        DBHelper.save(customer2);
        DBHelper.save(customer3);
        DBHelper.save(customer4);

        RestaurantTable restaurantTable1 = new RestaurantTable(1, 6, restaurant);
        RestaurantTable restaurantTable2 = new RestaurantTable(2, 4, restaurant);
        RestaurantTable restaurantTable3 = new RestaurantTable(3, 2, restaurant);
        RestaurantTable restaurantTable4 = new RestaurantTable(4, 6, restaurant);
        RestaurantTable restaurantTable5 = new RestaurantTable(5, 2, restaurant);
        DBHelper.save(restaurantTable1);
        DBHelper.save(restaurantTable2);
        DBHelper.save(restaurantTable3);
        DBHelper.save(restaurantTable4);
        DBHelper.save(restaurantTable5);

        Item item1 = new Item(ItemType.FAJITAS);
        Item item2 = new Item(ItemType.COLA);
        DBHelper.save(item1);
        DBHelper.save(item2);

        Date date1 = new Date(2018, 10, 2, 17, 10);
        Booking booking1 = new Booking(restaurant, restaurantTable1, date1, 120);
        Booking booking2 = new Booking(restaurant, restaurantTable2, date1, 60);
        Booking booking3 = new Booking(restaurant, restaurantTable3, date1, 120);
        DBHelper.save(booking1);
        DBHelper.save(booking2);
        DBHelper.save(booking3);

        booking1.addCustomer(customer1);
        booking2.addCustomer(customer2);
        booking3.addCustomer(customer3);
        DBHelper.save(booking1);
        DBHelper.save(booking2);
        DBHelper.save(booking3);

        Bill bill1 = new Bill(booking1);
        Bill bill2 = new Bill(booking2);
        Bill bill3 = new Bill(booking3);
        DBHelper.save(bill1);
        DBHelper.save(bill2);
        DBHelper.save(bill3);

    }
}
