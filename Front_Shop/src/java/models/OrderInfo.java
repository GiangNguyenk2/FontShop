/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Asus
 */
public class OrderInfo {
    private int orID;
    private int stockID;
    private int proID;
    private String proName;
    private int sizeID;
    private int colorID;
    private int quantity;
    private float proPrice;

    public OrderInfo() {
    }

    public OrderInfo(int orID, int stockID, int proID, String proName, int sizeID, int colorID, int quantity, float proPrice) {
        this.orID = orID;
        this.stockID = stockID;
        this.proID = proID;
        this.proName = proName;
        this.sizeID = sizeID;
        this.colorID = colorID;
        this.quantity = quantity;
        this.proPrice = proPrice;
    }

    public int getOrID() {
        return orID;
    }

    public void setOrID(int orID) {
        this.orID = orID;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getSizeID() {
        return sizeID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getProPrice() {
        return proPrice;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }
    
     
    
    
    
}
