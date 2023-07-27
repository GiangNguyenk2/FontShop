/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dinhd513
 */
public class CustomerFeedback {
    private int proID;
    private int rateStar;
    private String feedback;
    private String gmail;

    public CustomerFeedback() {
    }

    public CustomerFeedback(int proID, int rateStar, String feedback, String gmail) {
        this.proID = proID;
        this.rateStar = rateStar;
        this.feedback = feedback;
        this.gmail = gmail;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public int getRateStar() {
        return rateStar;
    }

    public void setRateStar(int rateStar) {
        this.rateStar = rateStar;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    
    
}
