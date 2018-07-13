package controllers;

import db.DBHelper;
import models.Booking;
import models.Restaurant;
import models.RestaurantTable;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            model.put("template", "templates/bookings/new.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/bookings/:num", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Booking booking = DBHelper.find(Booking.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/bookings/show.vtl");
            model.put("booking", booking);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/bookings/:num/edit", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Booking booking = DBHelper.find(Booking.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/bookings/edit.vtl");
            model.put("booking", booking);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/bookings", (req,res) -> {
//            Restaurant restaurant, RestaurantTable restaurantTable, Date dateTime, int bookingLength
            Restaurant restaurant = DBHelper.find(Restaurant.class, Integer.parseInt(req.queryParams("restaurant")));
            RestaurantTable table = DBHelper.find(RestaurantTable.class, Integer.parseInt(req.queryParams("restaurantTable")));
            String stringDate = req.queryParams("date");
            Date date = null;
            try { date = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").parse(stringDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int bookingLength = Integer.parseInt(req.queryParams("bookingLength"));
            Booking booking = new Booking(restaurant, table, date, bookingLength);

            res.redirect("/bookings");
            return null;
        }, new VelocityTemplateEngine());

        post("/bookings/:num/delete", (req,res) -> {
            Booking booking = DBHelper.find(Booking.class, Integer.parseInt(req.params(":num")));
            DBHelper.delete(booking);
            res.redirect("/bookings");
            return null;
        }, new VelocityTemplateEngine());
    }
}