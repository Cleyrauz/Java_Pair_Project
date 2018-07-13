package controllers;

import db.DBHelper;
import models.Bill;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

public class BillController {

    public BillController(){this.setupEndPoints();}

    public void setupEndPoints(){
        get("/bills", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Bill> bills = DBHelper.getAll(Bill.class);
            model.put("template", "templates/bills/index.vtl");
            model.put("bills", bills);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/bills/new", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/bills/new.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/bills/:num", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Bill bill = DBHelper.find(Bill.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/bills/show.vtl");
            model.put("bill", bill);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/bills/:num/edit", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Bill bill = DBHelper.find(Bill.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/tables/edit.vtl");
            model.put("bill", bill);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
