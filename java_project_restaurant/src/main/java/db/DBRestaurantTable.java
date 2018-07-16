package db;

import models.Booking;
import models.RestaurantTable;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBRestaurantTable {

    private static Transaction transaction;
    private static Session session;

    public static List<Booking> getTableBookings(RestaurantTable table){
        List<Booking> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Booking.class);
            cr.add(Restrictions.eq("restaurantTable", table));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
