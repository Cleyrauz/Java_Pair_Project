package db;

import models.Bill;
import models.Item;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DBBill {

    private static Transaction transaction;
    private static Session session;

    public static List<Item> findBillItems(Bill bill){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Item> results = null;
        try {
            Criteria cr = session.createCriteria(Item.class);
            cr.add(Restrictions.eq("bill", bill));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Item> findBillsItems(List<Bill> bills){
        List<Item> results = new ArrayList<>();
        for (Bill bill : bills) {
            results.addAll(findBillItems(bill));
        }
        return results;
    }
}
