/**
 *
 * @author GGPC
 */
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

public class CustomerSupplierGUI {

    private JFrame frame;
    private JPanel contentPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerSupplierGUI window = new CustomerSupplierGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CustomerSupplierGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

        JButton addButton = new JButton("Add Customer or Supplier");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle add customer / supplier
                System.out.println("add customer / supplier button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remove Customer or Supplier");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle remove logic
                System.out.println("remove button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(removeButton);

        JButton updateButton = new JButton("Update Information");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle update information
                System.out.println("update information button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(updateButton);
        
        JButton searchButton = new JButton("Search for Customer or Supplier");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle search
                System.out.println("Search button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(searchButton);
        
        JButton displayButton = new JButton("Display Information");
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle update information
                System.out.println("update information button clicked. Implement logic here.");
            }
        });
        buttonPanel.add(searchButton);

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


