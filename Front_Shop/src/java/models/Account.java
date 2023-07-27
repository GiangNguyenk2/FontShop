/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dinhd513
 */
public class Account {
    
    private String gmail;
    private String password;
    private String name;
    private boolean gender;
    private int roleID;
    private boolean accStatus;

    public Account() {
    }

    public Account(String gmail, String password, String name, boolean gender, int roleID, boolean accStatus) {
        this.gmail = gmail;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.roleID = roleID;
        this.accStatus = accStatus;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public boolean isAccStatus() {
        return accStatus;
    }

    public void setAccStatus(boolean accStatus) {
        this.accStatus = accStatus;
    }
    
    
    
    
    
    
    
}
