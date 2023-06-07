/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author GGPC
 */
public class OrdersController {
    
    private MainMenuGUI mainMenuGUI;
    private OrdersGUI ordersGUI;
    
    public OrdersController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        ordersGUI = OrdersGUI.getInstance();
        
        ordersGUI.getMainMenuButton().addActionListener(e -> openMainMenuGUI());
        ordersGUI.getViewOrderButton().addActionListener(e -> viewOrders());
        
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
    
}
    

