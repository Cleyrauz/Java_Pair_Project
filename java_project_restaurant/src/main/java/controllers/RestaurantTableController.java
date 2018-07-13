package controllers;

import db.DBHelper;
import models.Restaurant;
import models.RestaurantTable;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class RestaurantTableController {

    public RestaurantTableController(){this.setupEndPoints();}

    public void setupEndPoints(){
        get("/tables", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<RestaurantTable> tables = DBHelper.getAll(RestaurantTable.class);
            model.put("template", "templates/tables/index.vtl");
            model.put("tables", tables);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/tables/new", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/tables/new.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/tables/:num", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            RestaurantTable table = DBHelper.find(RestaurantTable.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/tables/show.vtl");
            model.put("table", table);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/tables/:num/edit", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            RestaurantTable table = DBHelper.find(RestaurantTable.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/tables/edit.vtl");
            model.put("table", table);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/tables", (req,res) -> {
//          int tableNumber, int capacity, Restaurant restaurant
            
            int tableNumber = Integer.parseInt(req.queryParams("tableNumber"));
            int capacity = Integer.parseInt(req.queryParams("capacity"));
            Restaurant restaurant = DBHelper.find(Restaurant.class, Integer.parseInt(req.queryParams("restaurant")));

            RestaurantTable restaurantTable = new RestaurantTable(tableNumber, capacity, restaurant);
            DBHelper.save(restaurantTable);
            res.redirect("/tables");
            return null;
        }, new VelocityTemplateEngine());
    }
}
