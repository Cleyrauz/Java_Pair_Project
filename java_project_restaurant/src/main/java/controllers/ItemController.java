package controllers;

import db.DBHelper;
import models.Item;
import models.ItemType;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class ItemController {

    public ItemController(){this.setupEndPoints();}

    public void setupEndPoints(){
        get("/items", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Item> items = DBHelper.getAll(Item.class);
            model.put("template", "templates/items/index.vtl");
            model.put("items", items);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/items/new", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/items/new.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/items/:num", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Item item = DBHelper.find(Item.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/items/show.vtl");
            model.put("item", item);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/items/:num/edit", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Item item = DBHelper.find(Item.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/items/edit.vtl");
            model.put("item", item);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("items", (req,res) -> {
//          ItemType type

            String type = req.queryParams("type");
            Item item = new Item(ItemType.valueOf(type));

            DBHelper.save(item);
            res.redirect("items");
            return null;
        }, new VelocityTemplateEngine());
    }
}
