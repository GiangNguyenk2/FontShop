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
import models.ComboDetails;
import models.ComboList;

/**
 *
 * @author Asus
 */
public class ComboDAO {
    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;    // keet qua tra ve

    
    public List<ComboDetails> getComboDetail() {
       List<ComboDetails> list = new ArrayList<>();
        String query = "select comboID, [Combo Detail].proID, proName, proPrice from Product , [Combo Detail] where Product.proID = [Combo Detail].proID";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ComboDetails(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getFloat(4)
                )
                );
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    public List<ComboList> getCombo() {
       List<ComboList> list = new ArrayList<>();
        String query = "select * from Combo";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ComboList(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getBoolean(4)      
                )
                );
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    
      public List<ComboDetails> getComboDetailByComboID(int comboID) {
       List<ComboDetails> list = new ArrayList<>();
        String query = "select comboID, [Combo Detail].proID, proName, proPrice from Product , [Combo Detail]"
                + " where Product.proID = [Combo Detail].proID  and comboID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, comboID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ComboDetails(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getFloat(4)
                )
                );
            }
        } catch (Exception e) {
        }
        return list;
    }
      
      public static void main(String[] args) {
          ComboDAO dao = new ComboDAO();
          List<ComboDetails> list = new ArrayList<>();
          list = dao.getComboDetailByComboID(2);
          for (ComboDetails comboDetails : list) {
              System.out.println(comboDetails.getProName());
          }
    }
    
  
    
    
    
    
    
    
    
}
