package inventorymanagementsystem;

public class InventoryController {

    private MainMenuGUI mainMenuGUI;
    private InventoryGUI inventoryGUI;

    public InventoryController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        inventoryGUI = InventoryGUI.getInstance();
        
        inventoryGUI.getDisplayInventoryButton().addActionListener(e -> inventoryGUI.displayInventory());

        inventoryGUI.getMainMenuButton().addActionListener(e -> openMainMenuGUI()); 
    }

    private void openMainMenuGUI() {
        inventoryGUI.getFrame().setVisible(false);
        mainMenuGUI.getFrame().setVisible(true);
    }

}
