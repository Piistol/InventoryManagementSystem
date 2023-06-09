package inventorymanagementsystem;

public class InventoryManagementSystem {

    public static void main(String[] args) {
        
        new LoginController();
        new MainMenuController();
        InventoryController.getInstance();
        new OrdersController();
        new ProductController();
        DBManager.getInstance();
    }   
}
