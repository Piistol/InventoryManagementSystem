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
    private JButton customersButton;
    private JButton ordersButton;
    private JButton logoutButton;

    // Making the constructor private to prevent instantiation
    private MainMenuGUI() {
        initialize();
    }

    // Providing global point of access
    public static MainMenuGUI getInstance() {
        if (instance == null) {
            instance = new MainMenuGUI();
        }
        return instance;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel MainMenuLabel = new JLabel("Main Menu");
        MainMenuLabel.setBounds(125, 15, 400, 20);
        frame.getContentPane().add(MainMenuLabel);

        inventoryButton = new JButton("Manage inventory");
        inventoryButton.setBounds(50, 50, 200, 25);
        frame.getContentPane().add(inventoryButton);

        customersButton = new JButton("Customers and Suppliers");
        customersButton.setBounds(50, 100, 200, 25);
        frame.getContentPane().add(customersButton);

        ordersButton = new JButton("Sales and Purchase Orders");
        ordersButton.setBounds(50, 150, 200, 25);
        frame.getContentPane().add(ordersButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 200, 200, 25);
        frame.getContentPane().add(logoutButton);
    }

    public JButton getInventoryButton() {
        return inventoryButton;
    }

    public JButton getCustomersButton() {
        return customersButton;
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


