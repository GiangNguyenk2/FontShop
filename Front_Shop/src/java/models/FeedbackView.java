/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ACER
 */
public class FeedbackView {
    private String name;
    private String gmail;
    private String proName;
    private String Feedback;
    private int RateStar;

    public FeedbackView() {
    }

    public FeedbackView(String name, String gmail, String proName, String Feedback, int RateStar) {
        this.name = name;
        this.gmail = gmail;
        this.proName = proName;
        this.Feedback = Feedback;
        this.RateStar = RateStar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String Feedback) {
        this.Feedback = Feedback;
    }

    public int getRateStar() {
        return RateStar;
    }

    public void setRateStar(int RateStar) {
        this.RateStar = RateStar;
    }
    
}
