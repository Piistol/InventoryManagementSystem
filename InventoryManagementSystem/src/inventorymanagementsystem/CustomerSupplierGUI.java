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

public class CustomerSupplierGUI {

    private JFrame frame;
    private JPanel contentPanel;
    private JButton addButton;
    private JButton removeButton;
    private JButton updateButton;
    private JButton searchButton;
    private JButton displayButton;
    private JButton mainMenuButton;

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

        addButton = new JButton("Add Customer or Supplier");
        buttonPanel.add(addButton);

        removeButton = new JButton("Remove Customer or Supplier");
        buttonPanel.add(removeButton);

        updateButton = new JButton("Update Information");
        buttonPanel.add(updateButton);
        
        searchButton = new JButton("Search for Customer or Supplier");
        buttonPanel.add(searchButton);
        
        displayButton = new JButton("Display Information");
        buttonPanel.add(displayButton);

        mainMenuButton = new JButton("Main Menu");
        buttonPanel.add(mainMenuButton);

        contentPanel = new JPanel();
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JButton getAddButton() {
        return this.addButton;
    }

    public JButton getRemoveButton() {
        return this.removeButton;
    }

    public JButton getUpdateButton() {
        return this.updateButton;
    }

    public JButton getSearchButton() {
        return this.searchButton;
    }

    public JButton getDisplayButton() {
        return this.displayButton;
    }

    public JButton getMainMenuButton() {
        return this.mainMenuButton;
    }
}



