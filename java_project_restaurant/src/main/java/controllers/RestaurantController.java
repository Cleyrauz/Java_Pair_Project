package controllers;

import db.DBHelper;
import models.Restaurant;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class RestaurantController {

    public RestaurantController(){this.setupEndPoints();}

    public void setupEndPoints(){
        get("/restaurants", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Restaurant> restaurants = DBHelper.getAll(Restaurant.class);
            model.put("template", "templates/restaurants/index.vtl");
            model.put("restaurants", restaurants);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/restaurants/new", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/restaurants/new.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/restaurants/:num", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Restaurant restaurant = DBHelper.find(Restaurant.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/restaurants/show.vtl");
            model.put("restaurant", restaurant);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/restaurants/:num/edit", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Restaurant restaurant = DBHelper.find(Restaurant.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/restaurants/edit.vtl");
            model.put("restaurant", restaurant);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/restaurants", (req,res) -> {
//          String name

            String name = req.queryParams("name");

            Restaurant restaurant = new Restaurant(name);
            DBHelper.save(restaurant);

            res.redirect("/restaurants");
            return null;
        }, new VelocityTemplateEngine());

        post("/restaurants/:num/delete", (req,res) -> {
            Restaurant restaurant = DBHelper.find(Restaurant.class, Integer.parseInt(req.params(":num")));
            DBHelper.delete(restaurant);
            res.redirect("/restaurants");
            return null;
        }, new VelocityTemplateEngine());
    }

}
