package db;

import models.Bill;
import models.Item;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBItem {

    private static Transaction transaction;
    private static Session session;

    public static List<Bill> findItemBills(Item item){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Bill> results = null;
        try {
            Criteria cr = session.createCriteria(Bill.class);

            cr.add(Restrictions.eq("items", item));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
