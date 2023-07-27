/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author DELL
 */
public class FeedbackDetail {
    private String name;
    private String gmail,proImg;
    private int phone;
    private String adderss,city,district,ward,proName,Feedback;
    private int RateStar;

    public FeedbackDetail() {
    }

    public FeedbackDetail(String name, String gmail, String proImg, int phone, String adderss, String city, String district, String ward, String proName, String Feedback, int RateStar) {
        this.name = name;
        this.gmail = gmail;
        this.proImg = proImg;
        this.phone = phone;
        this.adderss = adderss;
        this.city = city;
        this.district = district;
        this.ward = ward;
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

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdderss() {
        return adderss;
    }

    public void setAdderss(String adderss) {
        this.adderss = adderss;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
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
