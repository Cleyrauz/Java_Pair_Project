import db.DBHelper;
import models.*;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Item item = new Item(ItemType.FAJITAS);
        DBHelper.save(item);
    }
}
