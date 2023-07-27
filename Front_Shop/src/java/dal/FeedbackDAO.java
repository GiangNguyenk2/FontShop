/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Feedback;
import models.FeedbackDetail;
import models.FeedbackView;

/**
 *
 * @author DELL
 */
public class FeedbackDAO extends DBContext {

    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;    // keet qua tra ve

    public List<Feedback> getAllFeedback() {
        ArrayList<Feedback> list = new ArrayList<>();

        String sql = "   SELECT a.name,a.gmail,p.proName,f.Feedback , f.RateStar  FROM Feedback f\n"
                + "                join  Account a on f.gmail = a.gmail\n"
                + "               join Product p on f.proID = p.proID;";

        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);// chuẩn bị sql để chạy
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Feedback feedback = new Feedback(
                        rs.getString("name"),
                        rs.getString("gmail"),
                        rs.getString("proName"),
                        rs.getString("Feedback"),
                        rs.getInt("RateStar"));
                list.add(feedback);

            }
            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public int getTotalFeedback() {

        String query = "   SELECT count(*)  FROM Feedback f\n"
                + "                join  Account a on f.gmail = a.gmail\n"
                + "               join Product p on f.proID = p.proID";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<Feedback> paggingFeedback(int index) {
        List<Feedback> list = new ArrayList<>();
        String query = "    SELECT a.name,a.gmail,p.proName,f.Feedback , f.RateStar  FROM Feedback f\n"
                + "                join  Account a on f.gmail = a.gmail\n"
                + "               join Product p on f.proID = p.proID\n"
                + "			   order by f.proID offset ? row fetch next 5 row only ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feedback(
                        rs.getString("name"),
                        rs.getString("gmail"),
                        rs.getString("proName"),
                        rs.getString("Feedback"),
                        rs.getInt("RateStar")));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public List<Feedback> searchByName(String Search) {
        ArrayList<Feedback> list = new ArrayList<>();

        String sql = "    SELECT a.name,a.gmail,p.proName,f.Feedback , f.RateStar  FROM Feedback f\n"
                + "                join  Account a on f.gmail = a.gmail\n"
                + "               join Product p on f.proID = p.proID\n"
                + "			   where p.proName like ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + Search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Feedback feedback = new Feedback(
                        rs.getString("name"),
                        rs.getString("gmail"),
                        rs.getString("proName"),
                        rs.getString("Feedback"),
                        rs.getInt("RateStar"));
                list.add(feedback);

            }
            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public FeedbackDetail getFeedbackByName(String tt) {
        String query = "SELECT distinct a.name,a.gmail,pi.proImg,s.phone,s.address,s.city,s.district,s.ward,p.proName,f.Feedback , f.RateStar  FROM Feedback f\n" +
"                            join  Account a on f.gmail = a.gmail\n" +
"                            join Product p on f.proID = p.proID\n" +
"			                join Address s on s.gmail= a.gmail\n" +
"							join [Product Image] pi on pi.proID = p.proID\n" +
"							where p.proName like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + tt + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return new FeedbackDetail(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11));
                        

            }
            
    }catch(Exception ex){
        ex.printStackTrace();
    }
        return null;
    }
        
      public List<FeedbackView> getFeedbackProduct (int id) {
        ArrayList<FeedbackView> list = new ArrayList<>();

         String sql = "    SELECT a.name,a.gmail,p.proName,f.Feedback , f.RateStar  FROM Feedback f\n"
                + "                join  Account a on f.gmail = a.gmail\n"
                + "               join Product p on f.proID = p.proID\n"
                + "			   where p.proID =?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                FeedbackView feedback = new FeedbackView(
                        rs.getString("name"),
                        rs.getString("gmail"),
                        rs.getString("proName"),
                        rs.getString("Feedback"),
                        rs.getInt("RateStar"));
                list.add(feedback);

            }
            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
    
    

    public static void main(String[] args) {
        FeedbackDAO p = new FeedbackDAO();
       List <FeedbackView> f = p.getFeedbackProduct(1);
        for (FeedbackView feedback : f) {
            System.out.println(feedback.getName());
        }


        
    }
}
