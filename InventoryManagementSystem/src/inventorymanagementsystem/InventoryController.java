package inventorymanagementsystem;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class InventoryController {

    private static InventoryController instance = null;
    
    private MainMenuGUI mainMenuGUI;
    private InventoryGUI inventoryGUI;

    private InventoryController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        inventoryGUI = InventoryGUI.getInstance();

        

        inventoryGUI.getMainMenuButton().addActionListener(e -> openMainMenuGUI());
    }
    
    public static InventoryController getInstance() {
        if (instance == null) {
            instance = new InventoryController();
        }
        return instance;
    }

    private void openMainMenuGUI() {
        inventoryGUI.getFrame().setVisible(false);
        mainMenuGUI.getFrame().setVisible(true);
    }

    public void displayInventory() {

        inventoryGUI.getInventoryReport().setText(displayInventoryReport());
        List<Product> products = Product.getAllProducts();

        // Create column names
        String[] columnNames = {"Name", "Price ($)", "Weight (kg)", "Stock Level"};

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
        inventoryGUI.getProductTable().setModel(model);
        inventoryGUI.getProductTable().repaint();

    }

    public String displayInventoryReport() {
        StringBuilder report = new StringBuilder();
        double inventorySum = Product.getInventorySum();

        // Adding the total inventory sum to the report
        report.append("Total Inventory Value: $");
        report.append(String.format("%.2f\n\n", inventorySum));
        
        //Add total amount of products in the inventory
        report.append("Total amount of products in the inventory: ");
        report.append(Product.getTotalItems() + "\n\n");
        
        //Add total amount of UNIQUE products in the inventory
        report.append("Total number of unique products in the inventory: ");
        report.append(Product.getTotalUniqueItems() + "\n\n");
        
        //Add total weight of inventory
        report.append("Total weight of inventory: ");
        report.append(Product.getTotalWeight() + "(kg)\n\n");

        //Adding the list of products with low stock levels to the report
        List<Product> lowStock = Product.getLowStockProducts();
        if (!lowStock.isEmpty()) {
            report.append("The following items have low stock levels:\n");
            for (Product product : lowStock) {
                report.append(product + "\n");
            }
            report.append("Consider purchasing more of these products soon.");
        }
        return report.toString();
    }
}
