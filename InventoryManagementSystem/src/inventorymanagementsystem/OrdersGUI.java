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

public class OrdersGUI {

    private JFrame frame;
    private JPanel contentPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OrdersGUI window = new OrdersGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public OrdersGUI() {
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

        JButton createSalesOrderButton = new JButton("Create Sales Order");
        createSalesOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle create sales order
                System.out.println("Create Sales Order button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(createSalesOrderButton);

        JButton createPurchaseOrderButton = new JButton("Create Purchase Order");
        createPurchaseOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle create purchase order
                System.out.println("Create Purchase Order button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(createPurchaseOrderButton);

        JButton viewOrderButton = new JButton("View Order");
        viewOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle view order
                System.out.println("View Order button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(viewOrderButton);

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

