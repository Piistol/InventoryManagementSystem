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
public class InventoryManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new LoginController();
        new MainMenuController();
        new InventoryController();
        new OrdersController();
        new DBManager();
        
    }
    
}
