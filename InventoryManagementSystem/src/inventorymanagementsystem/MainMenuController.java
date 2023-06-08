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
    private ProductGUI productGUI;
    private ReportGUI reportGUI;
    private LoginGUI loginGUI;

    public MainMenuController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        ordersGUI = OrdersGUI.getInstance();
        inventoryGUI = InventoryGUI.getInstance();
        productGUI = ProductGUI.getInstance();
        reportGUI = ReportGUI.getInstance();
        loginGUI = LoginGUI.getInstance();

        mainMenuGUI.getInventoryButton().addActionListener(e -> openInventoryGUI());
        mainMenuGUI.getAddButton().addActionListener(e -> productGUI());
        mainMenuGUI.getReportButton().addActionListener(e -> openReportGUI());
        mainMenuGUI.getOrdersButton().addActionListener(e -> openOrdersGUI());
        mainMenuGUI.getLogoutButton().addActionListener(e -> openLoginGUI());
    }

    private void openInventoryGUI() {
        inventoryGUI.getFrame().setVisible(true);
        mainMenuGUI.getFrame().setVisible(false);
    }

    private void productGUI() {
        productGUI.getFrame().setVisible(true);
        mainMenuGUI.getFrame().setVisible(false);
    }

    private void openReportGUI() {
        reportGUI.getFrame().setVisible(true);
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


