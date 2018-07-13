package controllers;

import db.Seeds;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.text.ParseException;
import java.util.HashMap;
import static spark.Spark.get;

import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) throws ParseException {

        Seeds.seedData();

        staticFileLocation("/public");

        get("/home", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/home.vtl");
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