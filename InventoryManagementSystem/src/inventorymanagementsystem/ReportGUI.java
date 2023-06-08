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

public class ReportGUI {

    private static ReportGUI instance = null;

    private JFrame frame;
    private JButton mainMenuButton;

    private ReportGUI() {
        initialize();
    }

    public static ReportGUI getInstance() {
        if (instance == null) {
            instance = new ReportGUI();
        }
        return instance;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
       
        frame.getContentPane().add(buttonPanel, BorderLayout.WEST);

        mainMenuButton = new JButton("Main Menu");
        buttonPanel.add(mainMenuButton);

        frame.setVisible(false);
    }

    public JFrame getFrame() {
        return this.frame;
    }
    
    public JButton getMainMenuButton() {
        return this.mainMenuButton;
    }
}
