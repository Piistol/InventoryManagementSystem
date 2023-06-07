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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Order {
    private LocalDate orderDate;
    private Map<Product, Integer> orderedProducts;
    private String id;
    private static int nextId = 1;

    public Order(LocalDate orderDate, String prefix) {
        this.orderDate = orderDate;
        this.orderedProducts = new HashMap<>();
        this.id = generateId(prefix);
    }
    
    public void setId(String id) {
        this.id = id;
    }
    

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Map<Product, Integer> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(Map<Product, Integer> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public abstract void addProduct(Product product, int quantity);
    public abstract void removeProduct(Product product, int quantity);

    public double getOrderTotal() {
        return orderedProducts.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
    
    public String getId() {
        return id;
    }
    
    private String generateId(String prefix) {
        return prefix + nextId++;
    }
}

class PurchaseOrder extends Order {
    private String supplierId;
    private Inventory inventory;
    private double totalCost;

    public PurchaseOrder(LocalDate orderDate, String supplierId, Inventory inventory) {
        super(orderDate, "PO");
        this.supplierId = supplierId;
        this.inventory = inventory;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
    
    public double getTotalCost() {
        return totalCost;
    }
    
    public void calculateTotalCost() {
        totalCost = getOrderTotal();
    }

    @Override
    public void addProduct(Product product, int quantity) {
        getOrderedProducts().put(product, getOrderedProducts().getOrDefault(product, 0) + quantity);
        inventory.updateStockLevel(product, quantity);
    }

    @Override
    public void removeProduct(Product product, int quantity) {
        int currentQuantity = getOrderedProducts().getOrDefault(product, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Cannot remove more products than ordered.");
        }
        getOrderedProducts().put(product, currentQuantity - quantity);
        inventory.updateStockLevel(product, -quantity);
    }
}

class SalesOrder extends Order {
    private String customerId;
    private Inventory inventory;
    private double totalCost;

    public SalesOrder(LocalDate orderDate, String customerId, Inventory inventory) {
        super(orderDate, "SO");
        this.customerId = customerId;
        this.inventory = inventory;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    public double getTotalCost() {
        return totalCost;
    }
    
    public void calculateTotalCost() {
        totalCost = getOrderTotal();
    }

    @Override
    public void addProduct(Product product, int quantity) {
        getOrderedProducts().put(product, getOrderedProducts().getOrDefault(product, 0) + quantity);
        inventory.updateStockLevel(product, -quantity);
    }

    @Override
    public void removeProduct(Product product, int quantity) {
        int currentQuantity = getOrderedProducts().getOrDefault(product, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Cannot remove more products than ordered.");
        }
        getOrderedProducts().put(product, currentQuantity - quantity);
        inventory.updateStockLevel(product, quantity);
    }
}