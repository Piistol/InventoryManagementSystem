package inventorymanagementsystem;

import javax.swing.*;

public class ProductController {

    private MainMenuGUI mainMenuGUI;
    private ProductGUI productGUI;

    public ProductController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        productGUI = ProductGUI.getInstance();

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
        double price;
        double weight;
        int quantity;

        try {
            price = Double.parseDouble(productGUI.getPriceFieldText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(productGUI.getFrame(), "Invalid price format. Please enter a valid number.");
            return;
        }

        try {
            weight = Double.parseDouble(productGUI.getWeightFieldText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(productGUI.getFrame(), "Invalid weight format. Please enter a valid number.");
            return;
        }

        try {
            quantity = Integer.parseInt(productGUI.getQuantityFieldText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(productGUI.getFrame(), "Invalid quantity format. Please enter a valid number.");
            return;
        }

        // Check for negative values
        if (price < 0 || weight < 0 || quantity < 0) {
            JOptionPane.showMessageDialog(productGUI.getFrame(), "Price, weight and quantity cannot be negative. Please enter valid values.");
            return;
        }

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
