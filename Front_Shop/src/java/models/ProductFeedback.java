/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Asus
 */
public class ProductFeedback {
    private int proID;
    private float proRate;
    private String proFeedback;

    public ProductFeedback() {
    }

    public ProductFeedback(int proID, float proRate, String proFeedback) {
        this.proID = proID;
        this.proRate = proRate;
        this.proFeedback = proFeedback;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public float getProRate() {
        return proRate;
    }

    public void setProRate(float proRate) {
        this.proRate = proRate;
    }

    public String getProFeedback() {
        return proFeedback;
    }

    public void setProFeedback(String proFeedback) {
        this.proFeedback = proFeedback;
    }
    
    
}
