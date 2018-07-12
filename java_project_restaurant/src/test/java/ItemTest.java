import models.Item;
import models.ItemType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item(ItemType.FAJITAS);
    }

    @Test
    public void hasName() {
        assertEquals("Fajitas", item.getItemType().getName());
    }

    @Test
    public void hasCost() {
        assertEquals(10.50, item.getItemType().getPrice(), 0.01);
    }
}
