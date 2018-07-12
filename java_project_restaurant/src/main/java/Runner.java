import db.DBHelper;
import models.*;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Del Arepas");
        DBHelper.save(restaurant);
    }
}
