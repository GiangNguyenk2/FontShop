/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ACER
 */
public class Color {
    private int proColorID;
    private String proColorName;

    public Color() {
    }

    public Color(int proColorID, String proColorName) {
        this.proColorID = proColorID;
        this.proColorName = proColorName;
    }

    public int getProColorID() {
        return proColorID;
    }

    public void setProColorID(int proColorID) {
        this.proColorID = proColorID;
    }

    public String getProColorName() {
        return proColorName;
    }

    public void setProColorName(String proColorName) {
        this.proColorName = proColorName;
    }
    
    
    
}
