/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ACER
 */
public class Categories {
    
    private int caID;
    private String caName;

    public Categories() {
    }

    public Categories(int caID, String caName) {
        this.caID = caID;
        this.caName = caName;
    }

    public int getCaID() {
        return caID;
    }

    public void setCaID(int caID) {
        this.caID = caID;
    }

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName;
    }
    
    
}
