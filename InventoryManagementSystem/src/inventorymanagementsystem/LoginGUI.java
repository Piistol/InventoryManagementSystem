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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {

    private JFrame frame;

    //main only needed to test, will remove and make a LoginGUI object in InventoryManagementSystem main when ready
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginGUI window = new LoginGUI();
                    window.frame.setLocationRelativeTo(null);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginGUI() {
        initialize();
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

    JTextField usernameField = new JTextField();
    usernameField.setBounds(130, 60, 120, 20);
    frame.getContentPane().add(usernameField);
    usernameField.setColumns(10);

    JLabel lblUsername = new JLabel("Username");
    lblUsername.setBounds(60, 60, 80, 20);
    frame.getContentPane().add(lblUsername);

    JPasswordField passwordField = new JPasswordField();
    passwordField.setBounds(130, 90, 120, 20);
    frame.getContentPane().add(passwordField);

    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(60, 90, 80, 20);
    frame.getContentPane().add(lblPassword);

    //to be handled elsewhere
    JButton loginButton = new JButton("Login");
    loginButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // handle login
            System.out.println("Login button clicked. Implement login logic here.");
        }
    });
    loginButton.setBounds(60, 130, 80, 25);
    frame.getContentPane().add(loginButton);

    //handled elsewhere
    JButton registerButton = new JButton("Register");
    registerButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // handle registration
            System.out.println("Register button clicked. Implement registration logic here.");
        }
    });
    registerButton.setBounds(170, 130, 90, 25);
    frame.getContentPane().add(registerButton);
}

}
