/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author GGPC
 */
public class LoginController {
    
    private MainMenuGUI mainMenuGUI;
    private LoginGUI loginGUI;
    private DBManager dbmanager;
    
    public LoginController() {
        mainMenuGUI = MainMenuGUI.getInstance();
        loginGUI = LoginGUI.getInstance();
        dbmanager = DBManager.getInstance();
        
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
    String sql = "SELECT * FROM APP_USER WHERE USERNAME = ? AND PASSWORD = ?";

    try (PreparedStatement pstmt = dbmanager.getConnection().prepareStatement(sql)) {
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // A record was found with the given username and password, so they are valid credentials.
            return true;
        } else {
            // No record was found with the given username and password, so they are not valid credentials.
            return false;
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return false;
}

    
}

