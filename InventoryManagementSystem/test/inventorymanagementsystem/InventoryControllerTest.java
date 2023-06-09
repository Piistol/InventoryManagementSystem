package inventorymanagementsystem;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryControllerTest {

    private InventoryController inventoryController;

    @Before
    public void setUp() {
        inventoryController = InventoryController.getInstance();
    }

    @Test
    public void testGetInstance() {
        InventoryController instance = InventoryController.getInstance();
        assertNotNull(instance);
        assertEquals(instance, inventoryController);
    }

    @Test
    public void testDisplayInventory() {
        try {
            inventoryController.displayInventory();
        } catch (Exception e) {
            fail("displayInventory method should not throw an exception.");
        }
    }


    @Test
    public void testDisplayInventoryReport() {
        String report = inventoryController.displayInventoryReport();
        
        assertNotNull(report);
        assertFalse(report.isEmpty());

    }
}
