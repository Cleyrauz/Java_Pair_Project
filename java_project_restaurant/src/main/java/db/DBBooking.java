package db;

import models.Bill;
import models.Booking;
import models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DBBooking {
    private static Transaction transaction;
    private static Session session;

    public static List<Customer> findBookingCustomers(Booking booking){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> results = null;
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.id", booking.getId()));
            cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Customer> findBookingsCustomers(List<Booking> bookings){
        List<Customer> results = new ArrayList<>();
        for (Booking booking : bookings) {
            results.addAll(findBookingCustomers(booking));
        }
        return results;
    }

    public static Bill findBookingBill(Booking booking){
        session = HibernateUtil.getSessionFactory().openSession();
        Bill result = null;
        try {
            Criteria cr = session.createCriteria(Bill.class);
            cr.add(Restrictions.eq("booking", booking));
            result = (Bill) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static List<Bill> findBookingsBills(List<Booking> bookings){
        List<Bill> results = new ArrayList<>();
        for (Booking booking: bookings){
            results.add(findBookingBill(booking));
        }
        return results;
    }
}
