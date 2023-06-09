
package inventorymanagementsystem;

import org.junit.*;

public class MainMenuControllerTest {

    private MainMenuController mainMenuController;

    @Before
    public void setUp() {
        mainMenuController = new MainMenuController();
    }

    @Test
    public void mainMenuControllerInitialization_allFramesNotVisible() {
        Assert.assertFalse(MainMenuGUI.getInstance().getFrame().isVisible());
        Assert.assertFalse(OrdersGUI.getInstance().getFrame().isVisible());
        Assert.assertFalse(InventoryGUI.getInstance().getFrame().isVisible());
        Assert.assertFalse(ProductGUI.getInstance().getFrame().isVisible());
        Assert.assertFalse(LoginGUI.getInstance().getFrame().isVisible());
    }

    @After
    public void tearDown() {
       
    }
}
