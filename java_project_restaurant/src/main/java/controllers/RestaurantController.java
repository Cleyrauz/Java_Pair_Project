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
        get("/restaraunts", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Restaurant> restaurants = DBHelper.getAll(Restaurant.class);
            model.put("template", "templates/restaurants/index.vtl");
            model.put("restaurants", restaurants);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }


}
