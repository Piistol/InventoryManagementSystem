package inventorymanagementsystem;

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
    private JTextField idField;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField weightField;

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
       
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

       

        mainMenuButton = new JButton("Main Menu");
        buttonPanel.add(mainMenuButton);

        

        frame.setVisible(false);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    
    public JButton getMainMenuButton() {
        return this.mainMenuButton;
    }

    

}
