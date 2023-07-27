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
import models.Address;
import models.CustomerFeedback;
import models.CustomerOrder;
import models.Feedback;

import models.OrderInfo;
import models.Status;

/**
 *
 * @author Asus
 */
public class HistoryDAO {

    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;    // keet qua tra ve

    public List<CustomerOrder> getAllOrderByGmail(String gmail) {
        List<CustomerOrder> list = new ArrayList<>();

        String query = "select * from [Order] where gmail like ? order by orID DESC  ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + gmail + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CustomerOrder(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public CustomerOrder getOrder(int orID) {
        String query = "select * from [Order] where orID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new CustomerOrder(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6));

            }
        } catch (Exception e) {
        }
        return null;
    }

    public Address getAddress(int addID) {
        String query = "select * from [Address] where addID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, addID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Address(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));

            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<CustomerOrder> getStatusByOrder(int orID) {
        List<CustomerOrder> list = new ArrayList<>();

        String query = "select o.orID, o.orStatusID, s.orStatusName from [Status] s, [Order] o" + "where o.orStatusID = s.orStatusID and o.orID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CustomerOrder(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderInfo> getOrderInfoByOrID(int orID) {
        List<OrderInfo> list = new ArrayList<>();
        String sql = "select o.orID, o.stockID,s.proID,p.proName,s.proSizeID, s.proColorID, o.quantity, p.proPrice from Stock s , [Order Detail] o, Product p "
                + "where o.stockID = s.stockID and s.proID = p.proID and o.orID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderInfo(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getFloat(8)
                )
                );
            }
        } catch (Exception e) {
        }
        return list;

    }

    public void updateOrderStatus(int statusID, int orID) {
        String sql = "UPDATE [dbo].[Order]\n"
                + "   SET \n"
                + "      [orStatusID] = ?\n"
                + "     \n"
                + " WHERE orID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, statusID);
            ps.setInt(2, orID);
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    public void addFeedback(int proID, int rate, String feedback, String gmail) {
        String sql = "INSERT INTO [dbo].[Feedback]\n"
                + "           ([proID]\n"
                + "           ,[RateStar]\n"
                + "           ,[Feedback]\n"
                + "           ,[gmail])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, proID);
            ps.setInt(2, rate);
            ps.setString(3, feedback);
            ps.setString(4, gmail);
            ps.execute();
        } catch (Exception e) {
            // Xử lý ngoại lệ
        }
    }

    public CustomerFeedback findFeedback(String key, String gmail) {
        String sql = "SELECT [proID], [RateStar], [Feedback], [gmail]\n"
                + "FROM [dbo].[Feedback]\n"
                + "WHERE gmail = ? AND Feedback LIKE ?\n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, gmail);
            ps.setString(2, "%" + key + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return new CustomerFeedback(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ
        }
        return null;
    }

    public void updateFeedback(CustomerFeedback model, String key) {
        String sql = "UPDATE [dbo].[Feedback]\n"
                + "                 SET [RateStar] = ?\n"
                + "                     ,[Feedback] = ?\n"
                + "             WHERE Feedback like ?  and gmail = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, model.getRateStar());
            ps.setString(2, model.getFeedback());
            ps.setString(3, "%" + key + "%");
            ps.setString(4, model.getGmail());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        HistoryDAO dao = new HistoryDAO();
//        dao.addFeedback(2, 5, "hay", "8502dinhvando@gmail.com");
        CustomerFeedback test = dao.findFeedback("2 - RD Please Wake Up Tshirt - S - Black     :", "8502dinhvando@gmail.com");
        
        CustomerFeedback tnew = new CustomerFeedback(2, 1, "okkkkkk", "8502dinhvando@gmail.com");
        dao.updateFeedback(tnew, "2 - RD Please Wake Up Tshirt - S - Black     :");
    }

}
