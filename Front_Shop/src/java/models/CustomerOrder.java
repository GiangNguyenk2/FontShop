/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;

/**
 *
 * @author Asus
 */
public class CustomerOrder {
    private int orID;
    private Date dob;
    private String gmail;
    private float totalMoney;
    private int orStatusID;
    private int addID;

    public CustomerOrder() {
    }

    public CustomerOrder(int orID, Date dob, String gmail, float totalMoney, int orStatusID, int addID) {
        this.orID = orID;
        this.dob = dob;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
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
