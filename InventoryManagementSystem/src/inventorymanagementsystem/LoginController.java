package inventorymanagementsystem;

import javax.swing.JOptionPane;
import java.sql.*;

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

        loginGUI.getRegisterButton().addActionListener(e -> registerUser());

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
                // A record was found with the given username and password.
                return true;
            } else {
                // No record was found with the given username and password.
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(loginGUI.getFrame(), "An error occurred while checking credentials.");
            e.printStackTrace();
        }

        return false;
    }

    public void registerUser() {
        String username = loginGUI.getUsernameField().getText();
        String password = loginGUI.getPasswordField().getText();

        String checkSql = "SELECT * FROM APP_USER WHERE USERNAME = ?";

        try (PreparedStatement pstmt = dbmanager.getConnection().prepareStatement(checkSql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(loginGUI.getFrame(), "Username already exists. Please try again.");
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(loginGUI.getFrame(), "An error occurred while registering.");
            e.printStackTrace();
            return;
        }

        String insertSql = "INSERT INTO APP_USER (USERNAME, PASSWORD) VALUES (?, ?)";

        try (PreparedStatement pstmt = dbmanager.getConnection().prepareStatement(insertSql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(loginGUI.getFrame(), "Account creation successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(loginGUI.getFrame(), "Account could not be created, please try again.");
        }
    }

}
