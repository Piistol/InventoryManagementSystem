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

    // Assume constructors for the GUIs are already defined and initialize them

    public MainMenuController() {
        mainMenuGUI = new MainMenuGUI();
        ordersGUI = new OrdersGUI();
        inventoryGUI = new InventoryGUI();
        customerSupplierGUI = new CustomerSupplierGUI();
        loginGUI = new LoginGUI();

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

