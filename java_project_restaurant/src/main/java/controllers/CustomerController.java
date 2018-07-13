package controllers;

import db.DBHelper;
import models.Customer;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class CustomerController {
    public CustomerController(){this.setupEndPoints();}

    public void setupEndPoints(){
        get("/customers", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("template", "templates/customers/index.vtl");
            model.put("customers", customers);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/customers/new", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/customers/new.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/customers/:num", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Customer customer = DBHelper.find(Customer.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/customers/show.vtl");
            model.put("customer", customer);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/customers/:num/edit", (req,res) -> {
            HashMap<String, Object> model = new HashMap<>();
            Customer customer = DBHelper.find(Customer.class, Integer.parseInt(req.params(":num")));
            model.put("template", "templates/customers/edit.vtl");
            model.put("customer", customer);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
