package controllers;

import db.DBBooking;
import db.DBHelper;
import db.DBRestaurant;
import db.Seeds;
import models.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) throws ParseException {

        Seeds.seedData();

        staticFileLocation("/public");

        get("/home", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Restaurant> restaurants = DBHelper.getAll(Restaurant.class);
            model.put("template", "templates/home.vtl");
            model.put("restaurants", restaurants);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/home/restaurants", (req, res) -> {
            int restaurantId = Integer.parseInt(req.queryParams("restaurant_id"));
            HashMap<String, Object> model = new HashMap<>();
            Restaurant restaurant = DBHelper.find(Restaurant.class, restaurantId);
            model.put("template", "templates/home_restaurant.vtl");
            model.put("restaurant", restaurant);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/home/restaurants/:num/bills", (req,res) -> {
            int restaurantId = Integer.parseInt(req.params(":num"));
            HashMap<String, Object> model = new HashMap<>();
            Restaurant restaurant = DBHelper.find(Restaurant.class, restaurantId);
            List<Booking> bookings = DBRestaurant.getRestaurantsBookings(restaurant);
            List<Bill> bills = DBBooking.findBookingsBills(bookings);
            model.put("bills", bills);
            model.put("restaurant", restaurant);
            model.put("template", "templates/bills/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
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

        get("/home/restaurants/:num/customers", (req,res) -> {
            int restaurantId = Integer.parseInt(req.params(":num"));
            HashMap<String, Object> model = new HashMap<>();
            Restaurant restaurant = DBHelper.find(Restaurant.class, restaurantId);
            List<Booking> bookings = DBRestaurant.getRestaurantsBookings(restaurant);
            List<Customer> customers = DBBooking.findBookingsCustomers(bookings);
            model.put("customers", customers);
            model.put("restaurant", restaurant);
            model.put("template", "templates/customers/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        get("/home/restaurant/:num/items"


        get("/home/restaurants/:num/tables", (req,res) -> {
            int restaurantId = Integer.parseInt(req.params(":num"));
            HashMap<String, Object> model = new HashMap<>();
            Restaurant restaurant = DBHelper.find(Restaurant.class, restaurantId);
            List<RestaurantTable> tables = DBRestaurant.getRestaurantsTables(restaurant);
            model.put("tables", tables);
            model.put("restaurant", restaurant);
            model.put("template", "templates/tables/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        BillController billController = new BillController();
        BookingController bookingController = new BookingController();
        CustomerController customerController = new CustomerController();
        ItemController itemController = new ItemController();
        RestaurantController restaurantController = new RestaurantController();
        RestaurantTableController restaurantTableController = new RestaurantTableController();
    }
}