package inventorymanagementsystem;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class OrderTest {
    
    private Order order;
    private static Product product;

    @BeforeClass
    public static void setUpClass() {
        product = new Product("Product1", 100.0, 500.0, 10);
        Product.addProduct(product);
    }

    @Before
    public void setUp() {
        order = new Order();
    }

    @Test
    public void testAddItem() {
        order.addItem("Product1", 2);
        Assert.assertEquals(2, order.getItemQuantity("Product1"));
    }

    @Test
    public void testRemoveItem() {
        order.addItem("Product1", 2);
        order.removeItem("Product1");
        Assert.assertEquals(0, order.getItemQuantity("Product1"));
    }

    @Test
    public void testGetItemQuantity() {
        order.addItem("Product1", 2);
        Assert.assertEquals(2, order.getItemQuantity("Product1"));
    }

    @Test
    public void testGetItems() {
        order.addItem("Product1", 2);
        HashMap<String, Integer> expectedItems = new HashMap<>();
        expectedItems.put("Product1", 2);
        Assert.assertEquals(expectedItems, order.getItems());
    }

    @Test
    public void testGetTotalPrice() {
        order.addItem("Product1", 2);
        Double expectedPrice = 2 * product.getPrice();
        Assert.assertEquals(expectedPrice, order.getTotalPrice(order.getItems()));
    }


    @After
    public void tearDown() {

        order = null;
    }

    @AfterClass
    public static void tearDownClass() {
       
        Product.removeProduct("Product1");
        product = null;
    }
}
