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

public class ProductGUI {

    private static ProductGUI instance = null;

    private JFrame frame;
    private JButton mainMenuButton;
    private JButton addButton;
    private JButton removeButton;
    private JButton searchButton;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField quantityField;

    private ProductGUI() {
        initialize();
    }

    public static ProductGUI getInstance() {
        if (instance == null) {
            instance = new ProductGUI();
        }
        return instance;
    }

    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JLabel instructionLabel = new JLabel("Please enter the details of a product to add, remove or search from the Inventory (Remove and search only require name)");
        frame.getContentPane().add(instructionLabel, BorderLayout.NORTH);

        JPanel fieldPanel = new JPanel();
        frame.getContentPane().add(fieldPanel, BorderLayout.CENTER);
        fieldPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;

        JLabel nameLabel = new JLabel("Name:");
        fieldPanel.add(nameLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        nameField = new JTextField(20);
        fieldPanel.add(nameField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        JLabel priceLabel = new JLabel("Price ($):");
        fieldPanel.add(priceLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        priceField = new JTextField(20);
        fieldPanel.add(priceField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.NONE;
        JLabel weightLabel = new JLabel("Weight (kg):");
        fieldPanel.add(weightLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        weightField = new JTextField(20);
        fieldPanel.add(weightField, c);

        c.gridx = 0;
        c.gridy = 3;
        c.fill = GridBagConstraints.NONE;
        JLabel quantityLabel = new JLabel("Quantity:");
        fieldPanel.add(quantityLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        quantityField = new JTextField(20);
        fieldPanel.add(quantityField, c);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        addButton = new JButton("Add");
        buttonPanel.add(addButton);

        removeButton = new JButton("Remove");
        buttonPanel.add(removeButton);

        searchButton = new JButton("Search");
        buttonPanel.add(searchButton);

        mainMenuButton = new JButton("Main Menu");
        buttonPanel.add(mainMenuButton);

        frame.pack();
        frame.setVisible(false);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JButton getMainMenuButton() {
        return this.mainMenuButton;
    }

    public JButton getAddButton() {
        return this.addButton;
    }

    public JButton getRemoveButton() {
        return this.removeButton;
    }

    public JButton getSearchButton() {
        return this.searchButton;
    }
    
    public String getQuantityFieldText() {
        return this.quantityField.getText();
    }

    public String getNameFieldText() {
        return this.nameField.getText();
    }

    public String getPriceFieldText() {
        return this.priceField.getText();
    }

    public String getWeightFieldText() {
        return this.weightField.getText();
    }
}
