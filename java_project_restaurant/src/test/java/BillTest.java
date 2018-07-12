import models.Bill;
import models.Booking;
import models.Item;
import models.ItemType;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class BillTest {

    Bill bill;
    Item item;
    ArrayList<Item> items;
    Booking booking;

    @Before
    public void setUp() throws Exception {
        booking = new Booking();
        item = new Item(ItemType.FAJITAS);
        items = new ArrayList<>();
        items.add(item);
        bill = new Bill(items, booking);
    }
}
