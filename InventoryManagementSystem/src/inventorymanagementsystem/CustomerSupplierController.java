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
public class CustomerSupplierController {
    
    private MainMenuGUI mainMenuGUI;
    private CustomerSupplierGUI customerSupplierGUI;
    
    public CustomerSupplierController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        customerSupplierGUI = customerSupplierGUI.getInstance();
        
        customerSupplierGUI.getMainMenuButton().addActionListener(e -> openMainMenuGUI());
        
    }
    
    private void openMainMenuGUI() {
        customerSupplierGUI.getFrame().setVisible(false);
        mainMenuGUI.getFrame().setVisible(true);
    }
    
}
