package inventorymanagementsystem;

import java.awt.BorderLayout;
import javax.swing.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class InventoryGUI {

    private static InventoryGUI instance = null;

    private JFrame frame;
    private JButton mainMenuButton;
    private JButton displayInventoryButton;
    private JTable productTable;

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

        productTable = new JTable();
        frame.getContentPane().add(new JScrollPane(productTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        frame.getContentPane().add(buttonPanel, BorderLayout.WEST);

        mainMenuButton = new JButton("Main Menu");
        buttonPanel.add(mainMenuButton);

        displayInventoryButton = new JButton("Display or Refresh Inventory");
        buttonPanel.add(displayInventoryButton);

        frame.setVisible(false);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JButton getMainMenuButton() {
        return this.mainMenuButton;
    }

    public JButton getDisplayInventoryButton() {
        return this.displayInventoryButton;
    }

    public void displayInventory() {

        List<Product> products = Product.getAllProducts();

        // Create column names
        String[] columnNames = {"Name", "Price", "Weight", "Quantity"};

        // Create 2D array for table data
        Object[][] data = new Object[products.size()][columnNames.length];

        // Populate the data array with products
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            data[i][0] = product.getName();
            data[i][1] = product.getPrice();
            data[i][2] = product.getWeight();
            data[i][3] = product.getQuantity();
        }

        // Create a new TableModel
        TableModel model = new DefaultTableModel(data, columnNames);

        // Update the JTable with the new model
        productTable.setModel(model);
        productTable.repaint();
    }
}
