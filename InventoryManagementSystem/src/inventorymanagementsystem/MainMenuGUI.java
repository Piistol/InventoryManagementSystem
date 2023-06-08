/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

/**
 *
 * @author GGPC
 */
import javax.swing.*;

public class MainMenuGUI {

    private static MainMenuGUI instance = null;

    private JFrame frame;
    private JButton inventoryButton;
    private JButton addButton;
    private JButton removeButton;
    private JButton searchButton;
    private JButton reportButton;
    private JButton ordersButton;
    private JButton viewOrdersButton;
    private JButton logoutButton;

    private MainMenuGUI() {
        initialize();
    }

    public static MainMenuGUI getInstance() {
        if (instance == null) {
            instance = new MainMenuGUI();
        }
        return instance;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(75, 100, 300, 400); // Increase the height to fit the additional buttons
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel MainMenuLabel = new JLabel("Main Menu");
        MainMenuLabel.setBounds(125, 15, 400, 20);
        frame.getContentPane().add(MainMenuLabel);

        inventoryButton = new JButton("Display Inventory");
        inventoryButton.setBounds(50, 50, 200, 25);
        frame.getContentPane().add(inventoryButton);

        addButton = new JButton("Add/ Remove/ Search");
        addButton.setBounds(50, 90, 200, 25);
        frame.getContentPane().add(addButton);

        reportButton = new JButton("Inventory Report");
        reportButton.setBounds(50, 130, 200, 25);
        frame.getContentPane().add(reportButton);

        ordersButton = new JButton("Orders");
        ordersButton.setBounds(50, 170, 200, 25);
        frame.getContentPane().add(ordersButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 210, 200, 25);
        frame.getContentPane().add(logoutButton);
    }

    public JButton getInventoryButton() {
        return inventoryButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getReportButton() {
        return reportButton;
    }

    public JButton getOrdersButton() {
        return ordersButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JFrame getFrame() {
        return frame;
    }
}



