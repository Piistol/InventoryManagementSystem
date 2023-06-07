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
import javax.swing.*;

public class LoginGUI {

    private static LoginGUI instance = null;

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    // Making the constructor private to prevent instantiation
    private LoginGUI() {
        initialize();
    }

    // Providing global point of access
    public static LoginGUI getInstance() {
        if (instance == null) {
            instance = new LoginGUI();
        }
        return instance;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel welcomeLabel1 = new JLabel("Welcome to the Inventory Management System");
        welcomeLabel1.setBounds(20, 10, 400, 20);
        frame.getContentPane().add(welcomeLabel1);

        JLabel welcomeLabel2 = new JLabel("Please login or register");
        welcomeLabel2.setBounds(80, 30, 400, 20);
        frame.getContentPane().add(welcomeLabel2);

        usernameField = new JTextField();
        usernameField.setBounds(130, 60, 120, 20);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(60, 60, 80, 20);
        frame.getContentPane().add(lblUsername);

        passwordField = new JPasswordField();
        passwordField.setBounds(130, 90, 120, 20);
        frame.getContentPane().add(passwordField);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(60, 90, 80, 20);
        frame.getContentPane().add(lblPassword);

        loginButton = new JButton("Login");
        loginButton.setBounds(60, 130, 80, 25);
        frame.getContentPane().add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(170, 130, 90, 25);
        frame.getContentPane().add(registerButton);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JTextField getUsernameField() {
        return this.usernameField;
    }

    public JPasswordField getPasswordField() {
        return this.passwordField;
    }

    public JButton getLoginButton() {
        return this.loginButton;
    }

    public JButton getRegisterButton() {
        return this.registerButton;
    }
}


