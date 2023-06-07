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

public class ManageInventoryGUI {

    private JFrame frame;
    private JPanel contentPanel;

    //only used for testing
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManageInventoryGUI window = new ManageInventoryGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ManageInventoryGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

        JButton displayInventoryButton = new JButton("Display Inventory");
        displayInventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle display inventory
                System.out.println("Display Inventory button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(displayInventoryButton);

        JButton addProductButton = new JButton("Add Product");
        addProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle add product
                System.out.println("Add Product button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(addProductButton);

        JButton removeProductButton = new JButton("Remove Product");
        removeProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle remove product
                System.out.println("Remove Product button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(removeProductButton);

        JButton updateStockButton = new JButton("Update Stock Levels");
        updateStockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle update stock levels
                System.out.println("Update Stock Levels button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(updateStockButton);

        JButton generateReportButton = new JButton("Generate Inventory Report");
        generateReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle generate inventory report
                System.out.println("Generate Inventory Report button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(generateReportButton);

        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle main menu
                System.out.println("Main Menu button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(mainMenuButton);

        contentPanel = new JPanel();
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
    }
}
