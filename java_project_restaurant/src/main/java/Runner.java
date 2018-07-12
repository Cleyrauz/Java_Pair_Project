import db.DBHelper;
import models.*;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<RestaurantTable> tables = new ArrayList<>();
        Restaurant restaurant = new Restaurant("Del Arepas", tables);
        DBHelper.save(restaurant);
    }
}
