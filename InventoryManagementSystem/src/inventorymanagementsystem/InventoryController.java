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
public class InventoryController {
    
    private MainMenuGUI mainMenuGUI;
    private InventoryGUI inventoryGUI;
    
    public InventoryController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        inventoryGUI = InventoryGUI.getInstance();
        
        inventoryGUI.getMainMenuButton().addActionListener(e -> openMainMenuGUI());
        
    }
    
    private void openMainMenuGUI() {
        inventoryGUI.getFrame().setVisible(false);
        mainMenuGUI.getFrame().setVisible(true);
    }
    
}
