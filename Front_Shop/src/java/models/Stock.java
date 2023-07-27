/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ACER
 */
public class Stock {
     private int stockID;
    private int proID;
    private int proColorID;
    private int proSizeID;
    private int quantity;
    private boolean stockStatus;

    public Stock() {
    }

    public Stock(int stockID, int proID, int proColorID, int proSizeID, int quantity, boolean stockStatus) {
        this.stockID = stockID;
        this.proID = proID;
        this.proColorID = proColorID;
        this.proSizeID = proSizeID;
        this.quantity = quantity;
        this.stockStatus = stockStatus;
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

    public int getProColorID() {
        return proColorID;
    }

    public void setProColorID(int proColorID) {
        this.proColorID = proColorID;
    }

    public int getProSizeID() {
        return proSizeID;
    }

    public void setProSizeID(int proSizeID) {
        this.proSizeID = proSizeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(boolean stockStatus) {
        this.stockStatus = stockStatus;
    }
}
