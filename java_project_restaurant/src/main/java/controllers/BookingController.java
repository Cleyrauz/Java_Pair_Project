package controllers;

import db.*;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class BookingController {

    public BookingController(){this.setupEndPoints();}

    public void setupEndPoints(){
        get("/bookings", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Booking> bookings = DBHelper.getAll(Booking.class);
            model.put("template", "templates/bookings/index.vtl");
            model.put("bookings", bookings);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/bookings/new", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("template", "templates/bookings/new.vtl");
            model.put("customers", customers);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/home/restaurants/:num/bookings/new", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Restaurant restaurant = DBHelper.find(Restaurant.class, Integer.parseInt(req.params(":num")));
            List<RestaurantTable> tables = DBRestaurant.getRestaurantsTables(restaurant);
            List<Customer> customers = DBHelper.getAll(Customer.class);
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());

            model.put("template", "templates/bookings/new.vtl");
            model.put("tables", tables);
            model.put("restaurant", restaurant);
            model.put("customers", customers);
            model.put("today", date);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/bookings/:num", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Booking booking = DBHelper.find(Booking.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/bookings/show.vtl");
            model.put("booking", booking);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/home/restaurants/:num1/bookings/:num2", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Restaurant restaurant = DBHelper.find(Restaurant.class, Integer.parseInt(req.params(":num1")));
            Booking booking = DBHelper.find(Booking.class, Integer.parseInt(req.params(":num2")));
            Bill bill = DBBooking.findBookingBill(booking);
            List<Item> items = DBBill.findBillItems(bill);
            List<ItemType> types = DBItem.allItemTypes();
            double totalCost = DBItem.getTotalCost(items);
            model.put("template", "templates/bookings/show.vtl");
            model.put("showBill", "templates/bills/show.vtl");
            model.put("restaurant", restaurant);
            model.put("booking", booking);
            model.put("items", items);
            model.put("bill", bill);
            model.put("itemTypes", types);
            model.put("totalCost", totalCost);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/bookings/:num/edit", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Booking booking = DBHelper.find(Booking.class, Integer.parseInt(req.params(":num")));
            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("template", "templates/bookings/edit.vtl");
            model.put("booking", booking);
            model.put("customers", customers);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/home/restaurants/:num/bookings/new", (req,res) -> {
//            Restaurant restaurant, RestaurantTable restaurantTable, Date dateTime, int bookingLength, Customer customer, int quantity
            Restaurant restaurant = DBHelper.find(Restaurant.class, Integer.parseInt(req.params(":num")));
            int table_id = Integer.parseInt(req.queryParams("tableNumber"));
            RestaurantTable table = DBHelper.find(RestaurantTable.class, table_id);
            int customer_id = Integer.parseInt(req.queryParams("customer"));
            Customer customer = DBHelper.find(Customer.class, customer_id);
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            int bookingLength = Integer.parseInt(req.queryParams("length"));
            //timey wimey stuff
            String date = req.queryParams("date");
            String time = req.queryParams("time");
            String fullDateTime = date + " " + time;
            String pattern = "yyyy-MM-dd HH:mm";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date dateTime = null;
            try {
                dateTime = simpleDateFormat.parse(fullDateTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //timey wimey stuff over
            Booking booking = new Booking(restaurant, table, dateTime, bookingLength, customer, quantity);
            DBHelper.save(booking);
            res.redirect("/bookings");
            return null;
        }, new VelocityTemplateEngine());

        post("/restaurant/:rest_id/bookings/:num/edit", (req,res) -> {
            Restaurant restaurant = DBHelper.find(Restaurant.class, Integer.parseInt(req.params(":rest_id")));
            Booking bookingToDelete = DBHelper.find(Booking.class, Integer.parseInt(req.params(":num")));
            int table_id = Integer.parseInt(req.queryParams("tableNumber"));
            RestaurantTable table = DBHelper.find(RestaurantTable.class, table_id);
            int customer_id = Integer.parseInt(req.queryParams("customer"));
            Customer customer = DBHelper.find(Customer.class, customer_id);
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            int bookingLength = Integer.parseInt(req.queryParams("length"));

            //timey wimey stuff

            String fullDateTime = req.queryParams("dateTime");
            String pattern = "dd-MM-yyyy HH:mm";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date dateTime = null;
            try {
                dateTime = simpleDateFormat.parse(fullDateTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //timey wimey stuff over

            Booking booking = new Booking(restaurant, table, dateTime, bookingLength, customer, quantity);
   //         DBHelper.delete(bookingToDelete.getBill());
            DBHelper.delete(bookingToDelete);
            DBHelper.save(booking);

            res.redirect("/bookings");
            return null;
        }, new VelocityTemplateEngine());

        post("/bookings/:num/delete", (req,res) -> {
            Booking booking = DBHelper.find(Booking.class, Integer.parseInt(req.params(":num")));
            DBHelper.delete(booking);
            res.redirect("/bookings");
            return null;
        }, new VelocityTemplateEngine());

        get("/home/restaurants/:num/bookings", (req,res) -> {
            int restaurantId = Integer.parseInt(req.params(":num"));
            HashMap<String, Object> model = new HashMap<>();
            Restaurant restaurant = DBHelper.find(Restaurant.class, restaurantId);
            List<Booking> bookings = DBRestaurant.getRestaurantsBookings(restaurant);
            model.put("bookings", bookings);
            model.put("restaurant", restaurant);
            model.put("template", "templates/bookings/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
