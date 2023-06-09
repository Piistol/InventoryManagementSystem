package inventorymanagementsystem;

public class MainMenuController {

    private MainMenuGUI mainMenuGUI;
    private OrdersGUI ordersGUI;
    private InventoryGUI inventoryGUI;
    private ProductGUI productGUI;
    private LoginGUI loginGUI;
    private InventoryController inventoryController;

    public MainMenuController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        ordersGUI = OrdersGUI.getInstance();
        inventoryGUI = InventoryGUI.getInstance();
        productGUI = ProductGUI.getInstance();
        loginGUI = LoginGUI.getInstance();
        inventoryController = InventoryController.getInstance();

        mainMenuGUI.getInventoryButton().addActionListener(e -> openInventoryGUI());
        mainMenuGUI.getAddButton().addActionListener(e -> productGUI());
        mainMenuGUI.getOrdersButton().addActionListener(e -> openOrdersGUI());
        mainMenuGUI.getLogoutButton().addActionListener(e -> openLoginGUI());
    }

    private void openInventoryGUI() {
        inventoryGUI.getFrame().setVisible(true);
        mainMenuGUI.getFrame().setVisible(false);
        inventoryController.displayInventory();
    }

    private void productGUI() {
        productGUI.getFrame().setVisible(true);
        mainMenuGUI.getFrame().setVisible(false);
    }

    private void openOrdersGUI() {
        ordersGUI.getFrame().setVisible(true);
        mainMenuGUI.getFrame().setVisible(false);
    }

    private void openLoginGUI() {
        loginGUI.getFrame().setVisible(true);
        mainMenuGUI.getFrame().setVisible(false);
    }
}


