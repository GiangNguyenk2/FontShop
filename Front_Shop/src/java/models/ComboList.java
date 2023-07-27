/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Asus
 */
public class ComboList {
    private int comboID;
    private String comboName;
    private float Total_Money;
    private boolean conboStatus;

    public ComboList() {
    }

    public ComboList(int comboID, String comboName, float Total_Money, boolean conboStatus) {
        this.comboID = comboID;
        this.comboName = comboName;
        this.Total_Money = Total_Money;
        this.conboStatus = conboStatus;
    }

    public int getComboID() {
        return comboID;
    }

    public void setComboID(int comboID) {
        this.comboID = comboID;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public float getTotal_Money() {
        return Total_Money;
    }

    public void setTotal_Money(float Total_Money) {
        this.Total_Money = Total_Money;
    }

    public boolean isConboStatus() {
        return conboStatus;
    }

    public void setConboStatus(boolean conboStatus) {
        this.conboStatus = conboStatus;
    }
     
    
    
}
