/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ACER
 */
public class Order {
    
    private int orID;
    private String orDate;
    private String gmail;
    private double totalMoney;
    private int orStatusID;
    private int addID;
    public Order() {
    }

    public Order(int orID, String orDate, String gmail, double totalMoney, int orStatusID, int addID) {
        this.orID = orID;
        this.orDate = orDate;
        this.gmail = gmail;
        this.totalMoney = totalMoney;
        this.orStatusID = orStatusID;
        this.addID = addID;
    }

    public int getOrID() {
        return orID;
    }

    public void setOrID(int orID) {
        this.orID = orID;
    }

    public String getOrDate() {
        return orDate;
    }

    public void setOrDate(String orDate) {
        this.orDate = orDate;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getOrStatusID() {
        return orStatusID;
    }

    public void setOrStatusID(int orStatusID) {
        this.orStatusID = orStatusID;
    }

    public int getAddID() {
        return addID;
    }

    public void setAddID(int addID) {
        this.addID = addID;
    }

    

   

    
}
