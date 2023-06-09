package inventorymanagementsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Product {

    private String name;
    private double price;
    private double weight;
    private int quantity;
    private static DBManager dbManager = DBManager.getInstance();

    public Product(String name, double price, double weight, int quantity) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

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
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        this.weight = weight;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getCurrentQuantity() {
        String query = "SELECT QUANTITY FROM PRODUCT WHERE NAME = ?";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
            stmt.setString(1, this.name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("QUANTITY");
            } else {
                throw new SQLException("Product not found");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
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

    public static double getInventorySum() {
        String query = "SELECT SUM(PRICE * QUANTITY) AS total FROM PRODUCT";
        double total = 0;
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return total;
    }

    public static List<Product> getLowStockProducts() {
        String query = "SELECT * FROM PRODUCT WHERE QUANTITY <= 5";
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

    public static int getTotalItems() {
        String query = "SELECT SUM(QUANTITY) AS TOTAL FROM PRODUCT";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("TOTAL");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public static int getTotalUniqueItems() {
        String query = "SELECT COUNT(*) AS TOTAL FROM PRODUCT";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("TOTAL");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public static int getTotalWeight() {
        String query = "SELECT SUM(WEIGHT) AS TOTAL FROM PRODUCT";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("TOTAL");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public void reduceQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to reduce cannot be negative.");
        }
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            updateQuantityInDatabase();
        } else {
            System.out.println("Insufficient quantity.");
        }
    }

    public void addQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to add cannot be negative.");
        }
        this.quantity += quantity;
        updateQuantityInDatabase();
    }

    private void updateQuantityInDatabase() {
        String query = "UPDATE PRODUCT SET QUANTITY = ? WHERE NAME = ?";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
            stmt.setInt(1, this.quantity);
            stmt.setString(2, this.name);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
