package db;

import models.Booking;
import models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DBCustomer {
    private static Transaction transaction;
    private static Session session;
    private Object object;

    public static List<Booking> findCustomersBookings(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Booking> results = null;
        try {
            Criteria cr = session.createCriteria(Booking.class);
            cr.add(Restrictions.eq("customer", customer));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Customer> orderAllByBookingsNumber(){

        session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> customers = new ArrayList<>();
        List<Object> objects = null;
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "bookings");
            cr.setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("id"))
                    .add(Projections.count("bookings.id").as("frequency")));
            cr.addOrder(Order.desc("frequency"));
            objects = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        for (Object object : objects){
            Object id = ((Object[]) object)[0];
            Customer customer = DBHelper.find(Customer.class, (int)id);
            customers.add(customer);
        }
        return customers;
    }


}
