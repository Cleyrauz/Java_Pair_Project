package db;

import models.Booking;
import models.RestaurantTable;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    public static boolean checkForDoubleBooking(RestaurantTable table, Booking bookingToCheck){
        boolean result = true;
            Date dateTime = bookingToCheck.getDateTime();
            int length = bookingToCheck.getBookingLength();
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateTime);
            cal.add(Calendar.MINUTE, length);
            Date endDateTime = cal.getTime();

            List<Booking> bookings = getTableBookings(table);
            for (Booking booking : bookings){
                Date bookingDateTime = booking.getDateTime();
                int length2 = booking.getBookingLength();
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(bookingDateTime);
                cal2.add(Calendar.MINUTE, length2);
                Date bookingEndDateTime = cal2.getTime();

                if (dateTime.after(bookingDateTime) && dateTime.before(bookingEndDateTime)){
                    result = false;
                }
                if (endDateTime.before(bookingEndDateTime) && endDateTime.after(bookingDateTime)){
                    result = false;
                }
            }
            return result;
    }
}
