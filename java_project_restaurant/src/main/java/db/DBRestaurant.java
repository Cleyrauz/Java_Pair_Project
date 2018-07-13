package db;

import models.Restaurant;
import models.RestaurantTable;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBRestaurant {

    private static Transaction transaction;
    private static Session session;

    public static List<RestaurantTable> getRestaurantsTables(Restaurant restaurant){
        List<RestaurantTable> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(RestaurantTable.class);
            cr.add(Restrictions.eq("restaurant", restaurant));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
