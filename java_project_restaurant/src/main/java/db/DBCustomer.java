package db;

import models.Booking;
import models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCustomer {
    private static Transaction transaction;
    private static Session session;

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

}
