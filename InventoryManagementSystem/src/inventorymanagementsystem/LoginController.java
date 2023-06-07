/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

import javax.swing.JOptionPane;

/**
 *
 * @author GGPC
 */
public class LoginController {
    
    private MainMenuGUI mainMenuGUI;
    private LoginGUI loginGUI;
    
    public LoginController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        loginGUI = LoginGUI.getInstance();
        
        loginGUI.getLoginButton().addActionListener(e -> {
            if (checkCredentials(loginGUI.getUsernameField().getText(), 
                                 new String(loginGUI.getPasswordField().getPassword()))) {
                openMainMenuGUI();
            } else {
                JOptionPane.showMessageDialog(loginGUI.getFrame(), "Invalid username or password.");
            }
        });

        loginGUI.getFrame().setVisible(true);
    }
    
    private void openMainMenuGUI() {
        loginGUI.getFrame().setVisible(false);
        mainMenuGUI.getFrame().setVisible(true);
    }

    public boolean checkCredentials(String username, String password) {
        
        //Test for now
        if (username.equals("test") && password.equals("test")) {
            return true;
        }
        
        return false;
    }
    
}

