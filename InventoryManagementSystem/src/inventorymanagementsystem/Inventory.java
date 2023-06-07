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
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Inventory {
    private List<Product> products;
    private HashMap<String, Integer> stockLevels;

    public Inventory() {
        this.products = new ArrayList<>();
        this.stockLevels = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        products.add(product);
        stockLevels.put(product.getId(), quantity);
    }
    
    public List<Product> getProducts() {
        return products;
    }

    public void removeProduct(Product product) {
    String productId = product.getId();
    if (stockLevels.containsKey(productId)) {
        stockLevels.remove(productId);
        products.remove(product);
        System.out.println("Product removed from the inventory.");
    } else {
        System.out.println("Product not found in the inventory.");
    }
}

    public void updateStockLevel(Product product, int newQuantity) {
        stockLevels.put(product.getId(), newQuantity);
    }

    public int getStockLevel(Product product) {
        return stockLevels.getOrDefault(product.getId(), 0);
    }

    public Product findProductById(String productId) {
    for (Product product : products) {
        if (product.getId().equals(productId)) {
            return product;
        }
    }
    return null;
}
    
    public Product findProductByName(String productName) {
    for (Product product : products) {
        if (product.getName().equalsIgnoreCase(productName)) {
            return product;
        }
    }
    return null;
}
    
    public void adjustStockLevel(Product product, int adjustment) {
    String productId = product.getId();
    if (stockLevels.containsKey(productId)) {
        int currentStockLevel = stockLevels.get(productId);
        int newStockLevel = currentStockLevel + adjustment;
        
        if (newStockLevel < 0) {
            System.out.println("Cannot adjust stock level below zero.");
        } else {
            stockLevels.put(productId, newStockLevel);
        }
    } else {
        System.out.println("Product not found in the inventory.");
    }
}
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory:\n");
        for (Product product : products) {
            sb.append(product.toString());
            sb.append(", Stock Level: ");
            sb.append(stockLevels.get(product.getId()));
            sb.append("\n");
        }
        return sb.toString();
    }
}
