package db;

import models.Bill;
import models.Booking;
import models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class DBBooking {
    private static Transaction transaction;
    private static Session session;

    public static Customer findBookingCustomer(Booking booking){
        Customer result = DBHelper.find(Customer.class, booking.getCustomer().getId());
        return result;
    }

    public static List<Customer> findBookingsCustomers(List<Booking> bookings){
        List<Customer> results = new ArrayList<>();
        for (Booking booking : bookings) {
            results.add(findBookingCustomer(booking));
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
