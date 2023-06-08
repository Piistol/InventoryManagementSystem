/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

import javax.swing.*;

/**
 *
 * @author GGPC
 */
public class ProductController {

    private MainMenuGUI mainMenuGUI;
    private ProductGUI productGUI;
    private DBManager dbManager;

    public ProductController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        productGUI = ProductGUI.getInstance();
        dbManager = DBManager.getInstance();

        productGUI.getMainMenuButton().addActionListener(e -> openMainMenuGUI());
        productGUI.getAddButton().addActionListener(e -> addProduct());
        productGUI.getRemoveButton().addActionListener(e -> removeProduct());
        productGUI.getSearchButton().addActionListener(e -> searchProduct());
    }

    private void openMainMenuGUI() {
        productGUI.getFrame().setVisible(false);
        mainMenuGUI.getFrame().setVisible(true);
    }

    private void addProduct() {
        String name = productGUI.getNameFieldText();
        double price = Double.parseDouble(productGUI.getPriceFieldText());
        double weight = Double.parseDouble(productGUI.getWeightFieldText());
        int quantity = Integer.parseInt(productGUI.getQuantityFieldText());

        // Create a new Product
        Product product = new Product(name, price, weight, quantity);

        // Add the Product to the database
        boolean addedSuccessfully = Product.addProduct(product);

        // Check if the product was added successfully and give feedback to user
        if (addedSuccessfully) {
            JOptionPane.showMessageDialog(productGUI.getFrame(), "Product added successfully!");
        } else {
            JOptionPane.showMessageDialog(productGUI.getFrame(), "There was an error adding the product. Please try again.");
        }
    }

    private void removeProduct() {

        String name = productGUI.getNameFieldText();

        boolean removedSuccessfully = Product.removeProduct(name);

        if (removedSuccessfully) {
            JOptionPane.showMessageDialog(productGUI.getFrame(), "Product removed successfully!");
        } else {
            JOptionPane.showMessageDialog(productGUI.getFrame(), "Could not find product to remove. Please try again.");
        }
    }
    
    private void searchProduct() {
        
        String name = productGUI.getNameFieldText();
        
        Product product = Product.searchProduct(name);
        
        if (product != null) {
            JOptionPane.showMessageDialog(productGUI.getFrame(), product.toString());
        } else {
            JOptionPane.showMessageDialog(productGUI.getFrame(), "Could not find product. Please try again.");
        }
    }

}
