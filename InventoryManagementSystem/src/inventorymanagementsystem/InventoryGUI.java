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

public class InventoryGUI {

    private static InventoryGUI instance = null;

    private JFrame frame;
    private JPanel contentPanel;
    private JButton displayInventoryButton;
    private JButton addProductButton;
    private JButton removeProductButton;
    private JButton updateStockButton;
    private JButton generateReportButton;
    private JButton mainMenuButton;

    private InventoryGUI() {
        initialize();
    }

    public static InventoryGUI getInstance() {
        if (instance == null) {
            instance = new InventoryGUI();
        }
        return instance;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

        displayInventoryButton = new JButton("Display Inventory");
        buttonPanel.add(displayInventoryButton);

        addProductButton = new JButton("Add Product");
        buttonPanel.add(addProductButton);

        removeProductButton = new JButton("Remove Product");
        buttonPanel.add(removeProductButton);

        updateStockButton = new JButton("Update Stock Levels");
        buttonPanel.add(updateStockButton);

        generateReportButton = new JButton("Generate Inventory Report");
        buttonPanel.add(generateReportButton);

        mainMenuButton = new JButton("Main Menu");
        buttonPanel.add(mainMenuButton);

        contentPanel = new JPanel();
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JButton getDisplayInventoryButton() {
        return this.displayInventoryButton;
    }

    public JButton getAddProductButton() {
        return this.addProductButton;
    }

    public JButton getRemoveProductButton() {
        return this.removeProductButton;
    }

    public JButton getUpdateStockButton() {
        return this.updateStockButton;
    }

    public JButton getGenerateReportButton() {
        return this.generateReportButton;
    }

    public JButton getMainMenuButton() {
        return this.mainMenuButton;
    }
}


