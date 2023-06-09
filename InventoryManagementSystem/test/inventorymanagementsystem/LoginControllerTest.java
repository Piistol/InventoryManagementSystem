package inventorymanagementsystem;


import org.junit.*;

public class LoginControllerTest {

    private LoginController loginController;

    @Before
    public void setUp() {
        loginController = new LoginController();
    }

    @Test
    public void checkCredentials_withValidCredentials_returnsTrue() {
        String username = "testUser";
        String password = "testPass";

        boolean result = loginController.checkCredentials(username, password);

        Assert.assertTrue(result);
    }

    @Test
    public void checkCredentials_withInvalidCredentials_returnsFalse() {
        String username = "nonExistingUser";
        String password = "anyPassword";

        boolean result = loginController.checkCredentials(username, password);

        Assert.assertFalse(result);
    }

    @After
    public void tearDown() {
      
    }
}
