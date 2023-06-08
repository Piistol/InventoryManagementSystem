/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorytests;

/**
 *
 * @author GGPC
 */


import inventorymanagementsystem.DBManager;
import java.sql.*;

public class DBTest {

    private DBManager dbManager;

    public DBTest() {
        dbManager = DBManager.getInstance();
    }

    public void test() {
        populateTables();
        retrieveData();
    }

    public void populateTables() {
        try (Statement statement = dbManager.getConnection().createStatement()) {
            // Populate the PRODUCT table
            statement.execute("INSERT INTO PRODUCT (ID, NAME, PRICE, WEIGHT) VALUES ('P1', 'Product1', 100.0, 5.0)");
            statement.execute("INSERT INTO PRODUCT (ID, NAME, PRICE, WEIGHT) VALUES ('P2', 'Product2', 200.0, 10.0)");

            // Populate the APP_USER table
            statement.execute("INSERT INTO APP_USER (USERNAME, PASSWORD) VALUES ('user1', 'password1')");
            statement.execute("INSERT INTO APP_USER (USERNAME, PASSWORD) VALUES ('user2', 'password2')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void retrieveData() {
        try (Statement statement = dbManager.getConnection().createStatement()) {
            // Retrieve data from the PRODUCT table
            ResultSet rsProduct = statement.executeQuery("SELECT * FROM PRODUCT");
            System.out.println("Data in PRODUCT table:");
            while (rsProduct.next()) {
                System.out.println("ID: " + rsProduct.getString("ID") + ", Name: " + rsProduct.getString("NAME") 
                    + ", Price: " + rsProduct.getDouble("PRICE") + ", Weight: " + rsProduct.getDouble("WEIGHT"));
            }

            // Retrieve data from the APP_USER table
            ResultSet rsUser = statement.executeQuery("SELECT * FROM APP_USER");
            System.out.println("\nData in APP_USER table:");
            while (rsUser.next()) {
                System.out.println("Username: " + rsUser.getString("USERNAME") + ", Password: " + rsUser.getString("PASSWORD"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        DBTest dbTest = new DBTest();
        dbTest.test();
    }
}

