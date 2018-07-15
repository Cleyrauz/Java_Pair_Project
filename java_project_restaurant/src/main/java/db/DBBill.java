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
        List<Item> results = new ArrayList<>();
        List<Item> items = DBHelper.getAll(Item.class);
        for (Item item : items){
            if(item.getBill() != null) {
                if (item.getBill().getId() == bill.getId()) {
                    results.add(item);
                }
            }
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

    public static void removeItemFromBill(Bill bill, List<Item> items) {
        for(Item item : items){
            if(item.getBill().getId() == bill.getId()){
                item.setBill(null);
                DBHelper.save(item);
            }
        }
    }
}
