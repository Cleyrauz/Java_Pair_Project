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
import java.util.Date;
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

    public static List<Booking> findBookingsbyDate(Date startDate, Date endDate, List<Booking> searchGroup){
        List<Booking> results = new ArrayList<>();
        for (Booking booking : searchGroup){
            if (booking.getDateTime().before(endDate)){
                if (booking.getDateTime().after(startDate)){
                    results.add(booking);
                }
            }
        }
        return results;
    }
}
