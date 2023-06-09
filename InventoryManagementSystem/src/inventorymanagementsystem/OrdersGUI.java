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
import java.util.List;

public class OrdersGUI {

    private static OrdersGUI instance = null;

    private JFrame frame;
    private JPanel contentPanel;
    private JRadioButton salesOrderButton;
    private JRadioButton purchaseOrderButton;
    private JButton viewOrderButton;
    private JButton mainMenuButton;
    private JComboBox<String> itemsDropdown;
    private JTextField quantityField;
    private JButton addToOrderButton;
    private JList<String> orderItemsList;
    private JButton removeFromOrderButton;
    private JButton createOrderButton;
    private JTextField orderName;

    private OrdersGUI() {
        initialize();
    }

    public static OrdersGUI getInstance() {
        if (instance == null) {
            instance = new OrdersGUI();
        }
        return instance;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

        salesOrderButton = new JRadioButton("Sales Order", true);
        purchaseOrderButton = new JRadioButton("Purchase Order");

        ButtonGroup group = new ButtonGroup();
        group.add(salesOrderButton);
        group.add(purchaseOrderButton);

        viewOrderButton = new JButton("View Order");
        buttonPanel.add(viewOrderButton);

        mainMenuButton = new JButton("Main Menu");
        buttonPanel.add(mainMenuButton);

        buttonPanel.add(salesOrderButton);
        buttonPanel.add(purchaseOrderButton);

        contentPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel orderNameLabel = new JLabel("Order Name:");
        orderName = new JTextField(10);
        topPanel.add(orderNameLabel);
        topPanel.add(orderName);

        // Fetch the products from the database
        List<Product> products = Product.getAllProducts();

// Create an array to hold the product names
        String[] productNames = new String[products.size()];

// Populate the array with product names
        for (int i = 0; i < products.size(); i++) {
            productNames[i] = products.get(i).getName();
        }

// Create the dropdown list with the product names
        itemsDropdown = new JComboBox<>(productNames);
        topPanel.add(itemsDropdown);

        JLabel quantityLabel = new JLabel("Quantity:");
        topPanel.add(quantityLabel);
        
        quantityField = new JTextField(2);
        topPanel.add(quantityField);

        contentPanel.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel orderButtonsPanel = new JPanel();
        orderButtonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        addToOrderButton = new JButton("Add to Order");
        orderButtonsPanel.add(addToOrderButton);

        removeFromOrderButton = new JButton("Remove from Order");
        orderButtonsPanel.add(removeFromOrderButton);

        createOrderButton = new JButton("Create Order");
        orderButtonsPanel.add(createOrderButton);

        bottomPanel.add(orderButtonsPanel, BorderLayout.NORTH);

        // Create the list that shows products in the current order
        orderItemsList = new JList<>();
        bottomPanel.add(new JScrollPane(orderItemsList), BorderLayout.CENTER);

        contentPanel.add(bottomPanel, BorderLayout.CENTER);

        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JButton getAddToOrderButton() {
        return this.addToOrderButton;
    }

    public JButton getRemoveButton() {
        return this.removeFromOrderButton;
    }

    public JTextField getQuantityField() {
        return this.quantityField;
    }

    public JButton getViewOrderButton() {
        return this.viewOrderButton;
    }

    public JButton getMainMenuButton() {
        return this.mainMenuButton;
    }

    public JRadioButton getSalesOrderButton() {
        return this.salesOrderButton;
    }

    public JRadioButton getPurchaseOrderButton() {
        return this.purchaseOrderButton;
    }

    public JComboBox<String> getItemsDropdown() {
        return this.itemsDropdown;
    }

    public JList<String> getOrderItemsList() {
        return this.orderItemsList;
    }

    public JButton getCreateOrderButton() {
        return this.createOrderButton;
    }

    public JTextField getOrderName() {
        return this.orderName;
    }

}
