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
public class ReportController {

    private MainMenuGUI mainMenuGUI;
    private ReportGUI reportGUI;

    public ReportController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        reportGUI = ReportGUI.getInstance();

        reportGUI.getMainMenuButton().addActionListener(e -> openMainMenuGUI()); 
    }

    private void openMainMenuGUI() {
        reportGUI.getFrame().setVisible(false);
        mainMenuGUI.getFrame().setVisible(true);
    }

}
