/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GGPC
 */
public class Product {

    private String name;
    private double price;
    private double weight;
    private int quantity;
    private static DBManager dbManager = DBManager.getInstance();

    public Product(String name, double price, double weight, int quantity) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        return "Product{"
                + "name='" + name + '\''
                + ", price=$" + String.format("%.2f", price)
                + ", weight=" + String.format("%.2f", weight) + "g"
                + ", quantity=" + this.getQuantity()
                + '}';
    }

    public static boolean addProduct(Product product) {
        String query = "INSERT INTO PRODUCT (NAME, PRICE, WEIGHT, QUANTITY) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setDouble(3, product.getWeight());
            stmt.setInt(4, product.getQuantity());
            stmt.executeUpdate();
           
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static boolean removeProduct(String name) {
        String query = "DELETE FROM PRODUCT WHERE NAME = ?";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static Product searchProduct(String name) {
        String query = "SELECT * FROM PRODUCT WHERE NAME = ?";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double price = rs.getDouble("PRICE");
                double weight = rs.getDouble("WEIGHT");
                int quantity = rs.getInt("QUANTITY");
                Product product = new Product(name, price, weight, quantity);
               
                return product;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static List<Product> getAllProducts() {
        String query = "SELECT * FROM PRODUCT";
        List<Product> products = new ArrayList<>();
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("NAME");
                double price = rs.getDouble("PRICE");
                double weight = rs.getDouble("WEIGHT");
                int quantity = rs.getInt("QUANTITY");
                Product product = new Product(name, price, weight, quantity);
                products.add(product);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return products;
    }
}
