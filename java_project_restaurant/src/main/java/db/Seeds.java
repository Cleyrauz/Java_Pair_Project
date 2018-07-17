package db;

import models.*;

import java.text.ParseException;
import java.util.Date;

public class Seeds {

    public static void seedData() throws ParseException {

        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(Booking.class);
        DBHelper.deleteAll(RestaurantTable.class);
        DBHelper.deleteAll(Restaurant.class);

        Restaurant restaurant1 = new Restaurant("Arepas La Reina");
        DBHelper.save(restaurant1);

        Restaurant restaurant2 = new Restaurant("The Local Pie");
        DBHelper.save(restaurant2);

        Restaurant restaurant3 = new Restaurant("The Local Burger Co");
        DBHelper.save(restaurant3);

        Customer customer1 = new Customer("Matthew", "Bryce", 100.50);
        Customer customer2 = new Customer("Cleyra", "Uzcategui", 200.80);
        Customer customer3 = new Customer("Adri", "Florence", 90.20);
        Customer customer4 = new Customer("Jose", "Calderon", 200);
        DBHelper.save(customer1);
        DBHelper.save(customer2);
        DBHelper.save(customer3);
        DBHelper.save(customer4);

        RestaurantTable restaurantTable1 = new RestaurantTable(1, 6, restaurant1);
        RestaurantTable restaurantTable2 = new RestaurantTable(2, 4, restaurant1);
        RestaurantTable restaurantTable3 = new RestaurantTable(3, 2, restaurant1);
        RestaurantTable restaurantTable4 = new RestaurantTable(4, 6, restaurant1);
        RestaurantTable restaurantTable5 = new RestaurantTable(5, 2, restaurant1);
        DBHelper.save(restaurantTable1);
        DBHelper.save(restaurantTable2);
        DBHelper.save(restaurantTable3);
        DBHelper.save(restaurantTable4);
        DBHelper.save(restaurantTable5);

        RestaurantTable restaurantDelPie1 = new RestaurantTable(1, 6, restaurant2);
        RestaurantTable restaurantDelPie2 = new RestaurantTable(2, 4, restaurant2);
        RestaurantTable restaurantDelPie3 = new RestaurantTable(3, 2, restaurant2);
        RestaurantTable restaurantDelPie4 = new RestaurantTable(4, 6, restaurant2);
        RestaurantTable restaurantDelPie5 = new RestaurantTable(5, 2, restaurant2);
        DBHelper.save(restaurantDelPie1);
        DBHelper.save(restaurantDelPie2);
        DBHelper.save(restaurantDelPie3);
        DBHelper.save(restaurantDelPie4);
        DBHelper.save(restaurantDelPie5);

        RestaurantTable restaurantBurger1 = new RestaurantTable(1, 6, restaurant3);
        RestaurantTable restaurantBurger2 = new RestaurantTable(2, 4, restaurant3);
        RestaurantTable restaurantBurger3 = new RestaurantTable(3, 2, restaurant3);
        RestaurantTable restaurantBurger4 = new RestaurantTable(4, 6, restaurant3);
        RestaurantTable restaurantBurger5 = new RestaurantTable(5, 2, restaurant3);
        DBHelper.save(restaurantBurger1);
        DBHelper.save(restaurantBurger2);
        DBHelper.save(restaurantBurger3);
        DBHelper.save(restaurantBurger4);
        DBHelper.save(restaurantBurger5);

        Item item1 = new Item(ItemType.FAJITAS);
        Item item2 = new Item(ItemType.COLA);
        Item item3 = new Item(ItemType.AREPAS);
        Item item4 = new Item(ItemType.ENCHILADAS);
        Item item5 = new Item(ItemType.PINA_COLADA);
        Item item6 = new Item(ItemType.CHILLI);
        Item item7 = new Item(ItemType.KEBAB);
        Item item8 = new Item(ItemType.BURGER);
        Item item9 = new Item(ItemType.BEER);
        Item item10 = new Item(ItemType.PIE);
        DBHelper.save(item1);
        DBHelper.save(item2);
        DBHelper.save(item3);
        DBHelper.save(item4);
        DBHelper.save(item5);
        DBHelper.save(item6);
        DBHelper.save(item7);
        DBHelper.save(item8);
        DBHelper.save(item9);
        DBHelper.save(item10);

        Date date1 = new Date(118, 10, 2, 17, 10);
        Booking booking1 = new Booking(restaurant1, restaurantTable1, date1, 120, customer1, 3);
        Booking booking2 = new Booking(restaurant1, restaurantTable2, date1, 60, customer2, 3);
        Booking booking3 = new Booking(restaurant1, restaurantTable3, date1, 120, customer3, 5);
        Booking booking4 = new Booking(restaurant2, restaurantDelPie1, date1, 120, customer1, 3);
        Booking booking5 = new Booking(restaurant2, restaurantDelPie2, date1, 60, customer2, 3);
        Booking booking6 = new Booking(restaurant2, restaurantDelPie3, date1, 120, customer3, 5);
        Booking booking7 = new Booking(restaurant3, restaurantBurger1, date1, 120, customer1, 3);
        Booking booking8 = new Booking(restaurant3, restaurantBurger2, date1, 60, customer2, 3);
        Booking booking9 = new Booking(restaurant3, restaurantBurger3, date1, 120, customer3, 5);
        DBHelper.save(booking1);
        DBHelper.save(booking2);
        DBHelper.save(booking3);
        DBHelper.save(booking4);
        DBHelper.save(booking5);
        DBHelper.save(booking6);
        DBHelper.save(booking7);
        DBHelper.save(booking8);
        DBHelper.save(booking9);

        Bill bill1 = new Bill(booking1);
        Bill bill2 = new Bill(booking2);
        Bill bill3 = new Bill(booking3);
        Bill bill4 = new Bill(booking4);
        Bill bill5 = new Bill(booking5);
        Bill bill6 = new Bill(booking6);
        Bill bill7 = new Bill(booking7);
        Bill bill8 = new Bill(booking8);
        Bill bill9 = new Bill(booking9);
        DBHelper.save(item1);
        DBHelper.save(bill1);
        DBHelper.save(bill2);
        DBHelper.save(bill3);
        DBHelper.save(bill4);
        DBHelper.save(bill5);
        DBHelper.save(bill6);
        DBHelper.save(bill7);
        DBHelper.save(bill8);
        DBHelper.save(bill9);

        item1.setBill(bill1);
        item4.setBill(bill2);
        item3.setBill(bill3);
        item7.setBill(bill7);
        item8.setBill(bill8);
        item9.setBill(bill9);
        item2.setBill(bill5);
        item5.setBill(bill4);
        item6.setBill(bill6);
        item10.setBill(bill4);
        DBHelper.save(item1);
        DBHelper.save(item2);
        DBHelper.save(item3);
        DBHelper.save(item6);
        DBHelper.save(item7);
        DBHelper.save(item8);

//        item1.setBill(bill1);
//        item2.setBill(bill2);
//        item3.setBill(bill4);
//        item4.setBill(bill3);
//        item5.setBill(bill5);
//        item6.setBill(bill6);
//        item7.setBill(bill7);
//        item9.setBill(bill9);

//        DBHelper.save(item4);
//        DBHelper.save(item5);
//        DBHelper.save(item6);
//        DBHelper.save(item8);
//        DBHelper.save(item9);

    }
}
