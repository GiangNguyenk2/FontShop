/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Post {
    private String postID;
    private String tittle,gmail,toppic,img,detail;
    private Date dob;

    public Post() {
    }

    public Post(String postID, String tittle, String gmail, String toppic, String img, String detail, Date dob) {
        this.postID = postID;
        this.tittle = tittle;
        this.gmail = gmail;
        this.toppic = toppic;
        this.img = img;
        this.detail = detail;
        this.dob = dob;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getToppic() {
        return toppic;
    }

    public void setToppic(String toppic) {
        this.toppic = toppic;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

   
}