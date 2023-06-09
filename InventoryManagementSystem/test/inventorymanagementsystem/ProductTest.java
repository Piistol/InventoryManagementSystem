package inventorymanagementsystem;

import java.util.List;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        product = new Product("TestProduct", 100.0, 50.0, 20);
        Product.addProduct(product);
    }

    @Test
    public void testGetName() {
        assertEquals("TestProduct", product.getName());
    }

    @Test
    public void testSetName() {
        product.setName("NewTestProduct");
        assertEquals("NewTestProduct", product.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(100.0, product.getPrice(), 0.0);
    }

    @Test
    public void testSetPrice() {
        product.setPrice(200.0);
        assertEquals(200.0, product.getPrice(), 0.0);
    }

    @Test
    public void testGetWeight() {
        assertEquals(50.0, product.getWeight(), 0.0);
    }

    @Test
    public void testSetWeight() {
        product.setWeight(60.0);
        assertEquals(60.0, product.getWeight(), 0.0);
    }

    @Test
    public void testGetQuantity() {
        assertEquals(20, product.getQuantity());
    }

    @Test
    public void testGetCurrentQuantity() {
        
        assertEquals(20, product.getCurrentQuantity());
    }

    @Test
    public void testToString() {
        
        assertNotNull(product.toString());
    }

    @Test
    public void testAddProduct() {
        Product newProduct = new Product("NewProduct", 100.0, 50.0, 20);
        assertTrue(Product.addProduct(newProduct));
    }

    @Test
    public void testRemoveProduct() {
        assertTrue(Product.removeProduct(product.getName()));
    }

    @Test
    public void testSearchProduct() {
        Product foundProduct = Product.searchProduct("TestProduct");
        assertNotNull(foundProduct);
        assertEquals("TestProduct", foundProduct.getName());
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = Product.getAllProducts();
        assertNotNull(products);
        assertTrue(products.size() > 0);
    }

   
    @After
    public void tearDown() {
        Product.removeProduct(product.getName());
    }
}
