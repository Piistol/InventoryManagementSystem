package inventorymanagementsystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class InventoryGUI {

    private static InventoryGUI instance = null;

    private JFrame frame;
    private JButton mainMenuButton;
    private JTable productTable;
    private JTextArea inventoryReport;

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
        productTable.setAutoCreateRowSorter(true);
        frame.getContentPane().add(new JScrollPane(productTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        frame.getContentPane().add(buttonPanel, BorderLayout.WEST);

        mainMenuButton = new JButton("Main Menu");
        buttonPanel.add(mainMenuButton);


        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        inventoryReport = new JTextArea();
        inventoryReport.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(inventoryReport);
        scrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        buttonPanel.add(scrollPane);

        frame.setVisible(false);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JButton getMainMenuButton() {
        return this.mainMenuButton;
    }


    public JTable getProductTable() {
        return this.productTable;
    }
    
    public JTextArea getInventoryReport() {
        return this.inventoryReport;
    }
}
