/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.category;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class CategoryDTO implements Serializable{
    private int cateID;
    private String name;
    private String description;
    private boolean status;

    
    public CategoryDTO() {
    }

    
     public CategoryDTO(int cateID, String name, String description, boolean status) {
        this.cateID = cateID;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public CategoryDTO(int cateID, String name, String description) {
        this.cateID = cateID;
        this.name = name;
        this.description = description;
    }

    public CategoryDTO(int cateID, String name) {
        this.cateID = cateID;
        this.name = name;
    }

    public CategoryDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
      public CategoryDTO(String name, String description, boolean status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    

    
    
    
    
    /**
     * @return the cateID
     */
    public int getCateID() {
        return cateID;
    }

    /**
     * @param cateID the cateID to set
     */
    public void setCateID(int cateID) {
        this.cateID = cateID;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
