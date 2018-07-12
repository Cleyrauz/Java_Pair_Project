import db.DBHelper;
import models.Booking;
import models.Restaurant;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {

        DBHelper.deleteAll(Restaurant.class);

        Restaurant restaurant = new Restaurant("Del Arepas Escoces");
        DBHelper.save(restaurant);
    }
}
