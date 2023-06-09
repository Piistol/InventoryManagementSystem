/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author GGPC
 */
public class Order {

    private String name;
    private Date date;
    private String type;
    private Double totalPrice;
    private HashMap<String, Integer> items = new HashMap<>();

    public Order() {

    }

    public Order(String name, String type, HashMap<String, Integer> orderedProducts) {
        this.name = name;
        this.date = new java.util.Date();
        this.type = type;
        this.totalPrice = getTotalPrice(orderedProducts);
    }

    public void saveOrderToFile() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(this.getDate());

        String fileName = "Orders/" + this.getName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("Order Name: " + this.getName());
            writer.newLine();
            writer.write("Order Type: " + this.getType());
            writer.newLine();
            writer.write("Order Date: " + strDate);
            writer.newLine();
            writer.write("Ordered Products:");
            writer.newLine();

            for (HashMap.Entry<String, Integer> entry : this.getItems().entrySet()) {
                writer.write("Name: " + entry.getKey() + ", Quantity: " + entry.getValue());
                writer.newLine();
            }

            writer.write("Order Total: " + this.getTotalPrice(this.getItems()));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error writing to " + fileName + ": " + e.getMessage());
        }
    }

    public Double getTotalPrice(HashMap<String, Integer> orderedProducts) {

        Double sum = 0.0;

        for (HashMap.Entry<String, Integer> entry : items.entrySet()) {
            Product p = Product.searchProduct(entry.getKey());
            if (p != null) {
                sum += p.getPrice() * entry.getValue();
            }
        }

        return sum;
    }

    public String getName() {
        return this.name;
    }

    public Date getDate() {
        return this.date;
    }

    public String getType() {
        return this.type;
    }

    public void addItem(String item, int quantity) {
        items.put(item, quantity);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public int getItemQuantity(String item) {
        return items.getOrDefault(item, 0);
    }

    public HashMap<String, Integer> getItems() {
        return new HashMap<>(items);
    }
}
