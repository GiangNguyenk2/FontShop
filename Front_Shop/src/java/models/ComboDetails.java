/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Asus
 */

public class ComboDetails {
    private int comboID;
    private int proID;
    private String proName;
    private float proPrice;

    public ComboDetails() {
    }

    public ComboDetails(int comboID, int proID, String proName, float proPrice) {
        this.comboID = comboID;
        this.proID = proID;
        this.proName = proName;
        this.proPrice = proPrice;
    }

    public int getComboID() {
        return comboID;
    }

    public void setComboID(int comboID) {
        this.comboID = comboID;
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

    public float getProPrice() {
        return proPrice;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }

    

    
    
    
}
