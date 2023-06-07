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
import java.util.ArrayList;

public class Supplier {
    
    private String name;
    private String id;
    private String contact;
    private ArrayList<String> suppliedProductId;
    private static int nextId = 1;
    
    public Supplier(String name, String contact, ArrayList<String> suppliedProductId)
    {
        this.name = name;
        this.contact = contact;
        this.suppliedProductId = suppliedProductId;
        this.id = generateId();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the suppliedProductId
     */
    public ArrayList<String> getSuppliedProductId() {
        return suppliedProductId;
    }

    /**
     * @param suppliedProductId the suppliedProductId to set
     */
    public void setSuppliedProductId(ArrayList<String> suppliedProductId) {
        this.suppliedProductId = suppliedProductId;
    }
    
     private static synchronized String generateId() {
        return "S" + nextId++;
    }
}
