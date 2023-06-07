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

public class OrdersGUI {

    private JFrame frame;
    private JPanel contentPanel;
    private JButton createSalesOrderButton;
    private JButton createPurchaseOrderButton;
    private JButton viewOrderButton;
    private JButton mainMenuButton;

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

        createSalesOrderButton = new JButton("Create Sales Order");
        buttonPanel.add(createSalesOrderButton);

        createPurchaseOrderButton = new JButton("Create Purchase Order");
        buttonPanel.add(createPurchaseOrderButton);

        viewOrderButton = new JButton("View Order");
        buttonPanel.add(viewOrderButton);

        mainMenuButton = new JButton("Main Menu");
        buttonPanel.add(mainMenuButton);

        contentPanel = new JPanel();
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JButton getCreateSalesOrderButton() {
        return this.createSalesOrderButton;
    }

    public JButton getCreatePurchaseOrderButton() {
        return this.createPurchaseOrderButton;
    }

    public JButton getViewOrderButton() {
        return this.viewOrderButton;
    }

    public JButton getMainMenuButton() {
        return this.mainMenuButton;
    }
}


