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
public class OrdersController {
    
    private MainMenuGUI mainMenuGUI;
    private OrdersGUI ordersGUI;
    
    public OrdersController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        ordersGUI = OrdersGUI.getInstance();
        
        ordersGUI.getMainMenuButton().addActionListener(e -> openMainMenuGUI());
        
    }
    
    private void openMainMenuGUI() {
        ordersGUI.getFrame().setVisible(false);
        mainMenuGUI.getFrame().setVisible(true);
    }
    
}
    

