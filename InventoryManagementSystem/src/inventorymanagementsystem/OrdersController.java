package inventorymanagementsystem;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class OrdersController {

    private MainMenuGUI mainMenuGUI;
    private OrdersGUI ordersGUI;
    private Order currentOrder;

    private static final String ORDER_TYPE_SALES = "Sales";
    private static final String ORDER_TYPE_PURCHASE = "Purchase";

    public OrdersController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        ordersGUI = OrdersGUI.getInstance();

        ordersGUI.getMainMenuButton().addActionListener(e -> openMainMenuGUI());
        ordersGUI.getViewOrderButton().addActionListener(e -> viewOrders());
        ordersGUI.getAddToOrderButton().addActionListener(e -> addProductToOrder());
        ordersGUI.getRemoveButton().addActionListener(e -> removeProductFromOrder());
        ordersGUI.getCreateOrderButton().addActionListener(e -> createOrder());

    }

    private void openMainMenuGUI() {
        ordersGUI.getFrame().setVisible(false);
        mainMenuGUI.getFrame().setVisible(true);
    }

    private void viewOrders() {
        JFileChooser imageFileChooser = new JFileChooser();
        imageFileChooser.setCurrentDirectory(new File("orders"));

        int result = imageFileChooser.showOpenDialog(ordersGUI.getFrame());

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = imageFileChooser.getSelectedFile();

            try {
                Desktop.getDesktop().open(selectedFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void addProductToOrder() {

        if (currentOrder == null) {
            currentOrder = new Order();
        }

        String selectedProductName = (String) ordersGUI.getItemsDropdown().getSelectedItem();
        try {
            int quantityToOrder = Integer.parseInt(ordersGUI.getQuantityField().getText());
            Product selectedProduct = Product.searchProduct(selectedProductName);

            // Get the current quantity of the product in the order, if it exists
            int currentProductOrderQuantity = currentOrder.getItemQuantity(selectedProductName);

            // Check if this is a purchase order. If so, do not check for enough quantity.
            boolean isPurchaseOrder = ordersGUI.getPurchaseOrderButton().isSelected();

            if (isPurchaseOrder || selectedProduct.getCurrentQuantity() >= quantityToOrder + currentProductOrderQuantity) {
                // Add the selected product to the order
                currentOrder.addItem(selectedProductName, quantityToOrder);

                // Update the order items list
                DefaultListModel<String> listModel = new DefaultListModel<>();
                for (HashMap.Entry<String, Integer> entry : currentOrder.getItems().entrySet()) {
                    listModel.addElement(entry.getKey() + ": " + entry.getValue());
                }
                ordersGUI.getOrderItemsList().setModel(listModel);
            } else {
                // Show error message
                JOptionPane.showMessageDialog(ordersGUI.getFrame(),
                        "Not enough quantity available for " + selectedProduct.getName(),
                        "Insufficient Quantity",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(ordersGUI.getFrame(), "Please enter a valid quantity.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeProductFromOrder() {
        // get the selected item
        String selectedItem = (String) ordersGUI.getOrderItemsList().getSelectedValue();

        // remove the selected item from the order
        if (selectedItem != null) {
            currentOrder.removeItem(selectedItem);

            // update the list in the GUI
            DefaultListModel<String> listModel = (DefaultListModel<String>) ordersGUI.getOrderItemsList().getModel();
            listModel.removeElement(selectedItem);
        } else {
            // show error message if no item is selected
            JOptionPane.showMessageDialog(ordersGUI.getFrame(),
                    "Please select an item to remove",
                    "No Item Selected",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void createOrder() {
        // Get order name and type from the GUI
        String orderName = ordersGUI.getOrderName().getText();

        String orderType = null;

        if (ordersGUI.getSalesOrderButton().isSelected()) {
            orderType = ORDER_TYPE_SALES;
        }

        if (ordersGUI.getPurchaseOrderButton().isSelected()) {
            orderType = ORDER_TYPE_PURCHASE;
        }

        // Validate order name and type
        if (orderName == null || orderName.isEmpty()) {
            JOptionPane.showMessageDialog(ordersGUI.getFrame(), "Order name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (orderType == null || (!orderType.equals("Sales") && !orderType.equals("Purchase"))) {
            JOptionPane.showMessageDialog(ordersGUI.getFrame(), "Invalid order type.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a new order
        Order order = new Order(orderName, orderType, currentOrder.getItems());

        // Add items to the order
        for (HashMap.Entry<String, Integer> entry : currentOrder.getItems().entrySet()) {
            String itemName = entry.getKey();
            int itemQuantity = entry.getValue();
            order.addItem(itemName, itemQuantity);
        }

        // Update inventory based on order type
        for (HashMap.Entry<String, Integer> entry : order.getItems().entrySet()) {
            Product product = Product.searchProduct(entry.getKey());
            if (product != null) {
                if (orderType.equals(ORDER_TYPE_SALES)) {
                    product.reduceQuantity(entry.getValue());
                } else if (orderType.equals(ORDER_TYPE_PURCHASE)) {
                    product.addQuantity(entry.getValue());
                }
            }
        }

        // Save order to file
        order.saveOrderToFile();

        // Clear current order
        currentOrder = null;

        // Update GUI
        DefaultListModel<String> listModel = new DefaultListModel<>();
        ordersGUI.getOrderItemsList().setModel(listModel);
        ordersGUI.getOrderName().setText("");
        ordersGUI.getQuantityField().setText("1");
        JOptionPane.showMessageDialog(ordersGUI.getFrame(), "Order has been created!");
    }

}
