/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Asus
 */
public class Status {
    private int orStatusID;
    private String OrStatusName;

    public Status() {
    }

    public Status(int orStatusID, String OrStatusName) {
        this.orStatusID = orStatusID;
        this.OrStatusName = OrStatusName;
    }

    public int getOrStatusID() {
        return orStatusID;
    }

    public void setOrStatusID(int orStatusID) {
        this.orStatusID = orStatusID;
    }

    public String getOrStatusName() {
        return OrStatusName;
    }

    public void setOrStatusName(String OrStatusName) {
        this.OrStatusName = OrStatusName;
    }

    
    
    
    
}
