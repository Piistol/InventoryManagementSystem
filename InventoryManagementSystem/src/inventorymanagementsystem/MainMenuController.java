/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

public class MainMenuController {
    private MainMenuGUI mainMenuGUI;
    private OrdersGUI ordersGUI;
    private InventoryGUI inventoryGUI;
    private CustomerSupplierGUI customerSupplierGUI;
    private LoginGUI loginGUI;

    public MainMenuController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        ordersGUI = OrdersGUI.getInstance();
        inventoryGUI = InventoryGUI.getInstance();
        customerSupplierGUI = CustomerSupplierGUI.getInstance();
        loginGUI = LoginGUI.getInstance();

        mainMenuGUI.getOrdersButton().addActionListener(e -> openOrdersGUI());
        mainMenuGUI.getInventoryButton().addActionListener(e -> openInventoryGUI());
        mainMenuGUI.getCustomersButton().addActionListener(e -> openCustomerSupplierGUI());
        mainMenuGUI.getLogoutButton().addActionListener(e -> openLoginGUI());
    }

    private void openOrdersGUI() {
        ordersGUI.getFrame().setVisible(true);
        mainMenuGUI.getFrame().setVisible(false);
    }

    private void openInventoryGUI() {
        inventoryGUI.getFrame().setVisible(true);
        mainMenuGUI.getFrame().setVisible(false);
    }

    private void openCustomerSupplierGUI() {
        customerSupplierGUI.getFrame().setVisible(true);
        mainMenuGUI.getFrame().setVisible(false);
    }

    private void openLoginGUI() {
        loginGUI.getFrame().setVisible(true);
        mainMenuGUI.getFrame().setVisible(false);
    }
}

