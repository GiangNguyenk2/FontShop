/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ACER
 */
public class Product {
    private int proID;
    private String proName;
    private String proDetail;
    private Float proPrice;
    private int caID;
    private boolean proStatus;

    public Product() {
    }

    public Product(int proID, String proName, String proDetail, Float proPrice, int caID, boolean proStatus) {
        this.proID = proID;
        this.proName = proName;
        this.proDetail = proDetail;
        this.proPrice = proPrice;
        this.caID = caID;
        this.proStatus = proStatus;
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

    public String getProDetail() {
        return proDetail;
    }

    public void setProDetail(String proDetail) {
        this.proDetail = proDetail;
    }

    public Float getProPrice() {
        return proPrice;
    }

    public void setProPrice(Float proPrice) {
        this.proPrice = proPrice;
    }

    public int getCaID() {
        return caID;
    }

    public void setCaID(int caID) {
        this.caID = caID;
    }

    public boolean isProStatus() {
        return proStatus;
    }

    public void setProStatus(boolean proStatus) {
        this.proStatus = proStatus;
    }
    
    
}
