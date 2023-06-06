/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GGPC
 */
public class DBManager {
    
    Connection connection;
    
    private static final String URL = "jdbc:derby:InventoryDB;create=true";  //url of the DB
    
    public DBManager()
    {
        establishConnection();
    }
    
    //Establish database connection
    public void establishConnection() {
        if (this.connection == null) {
            try {
                connection = DriverManager.getConnection(URL);
                System.out.println(URL + " Get Connected Successfully ....");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void closeConnections() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public Connection getConnection() {
        return this.connection;
    }
    
    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        System.out.println(dbManager.getConnection());
    }
}
