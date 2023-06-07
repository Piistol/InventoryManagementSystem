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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenuGUI window = new MainMenuGUI();
                    window.frame.setLocationRelativeTo(null);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainMenuGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel MainMenuLabel = new JLabel("Main Menu");
        MainMenuLabel.setBounds(125, 15, 400, 20);
        frame.getContentPane().add(MainMenuLabel);

        JButton inventoryButton = new JButton("Manage inventory");
        inventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle inventory
                System.out.println("Inventory button clicked. Implement inventory logic here.");
            }
        });
        inventoryButton.setBounds(50, 50, 200, 25);
        frame.getContentPane().add(inventoryButton);

        JButton customersButton = new JButton("Customers and Suppliers");
        customersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle customers and suppliers
                System.out.println("Customers and Suppliers button clicked. Implement customers logic here.");
            }
        });
        customersButton.setBounds(50, 100, 200, 25);
        frame.getContentPane().add(customersButton);

        JButton salesPurchasesButton = new JButton("Sales and Purchase Orders");
        salesPurchasesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle sales and purchase Orders
                System.out.println("sales and purchase orders orders clicked. Implement logic here.");
            }
        });
        salesPurchasesButton.setBounds(50, 150, 200, 25);
        frame.getContentPane().add(salesPurchasesButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle logout (return to loginGUI)
                System.out.println("logout button clicked. Implement logic here.");
            }
        });
        logoutButton.setBounds(50, 200, 200, 25);
        frame.getContentPane().add(logoutButton);
    }
}
