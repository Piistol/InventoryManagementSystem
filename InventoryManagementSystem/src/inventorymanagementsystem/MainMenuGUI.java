package inventorymanagementsystem;

import javax.swing.*;

public class MainMenuGUI {

    private static MainMenuGUI instance = null;

    private JFrame frame;
    private JButton inventoryButton;
    private JButton addButton;
    private JButton ordersButton;
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
        frame.setBounds(75, 100, 300, 400);
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

        ordersButton = new JButton("Orders");
        ordersButton.setBounds(50, 130, 200, 25);
        frame.getContentPane().add(ordersButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 170, 200, 25);
        frame.getContentPane().add(logoutButton);
    }

    public JButton getInventoryButton() {
        return inventoryButton;
    }

    public JButton getAddButton() {
        return addButton;
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
