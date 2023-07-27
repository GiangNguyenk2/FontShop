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
import models.ComboList;
import models.Product;
import models.ProductImage;

/**
 *
 * @author admin
 */
public class SaleDAO {
    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;
    
    public int getTotalOfCombo() {
        String sql = "select COUNT(*) from Combo";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int getTotalOfProduct() {
        String sql = "select COUNT(*) from Product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int getTotalOfOrder(){
        String sql = "SELECT SUM (quantity) FROM [Order Detail]";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    
    public Product getProductByID(int id) {
        String sql = "select * from Product where proID=?";
        Product p = new Product();
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                p.setProID(rs.getInt("proID"));
                p.setProName(rs.getString("proName"));
                p.setProDetail(rs.getString("proDetail"));
                p.setProPrice(rs.getFloat("proPrice"));
                p.setCaID(rs.getInt("caID"));
                p.setProStatus(rs.getBoolean("proStatus"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }
    
    public ProductImage getImageById(int id) {

        String sql = "select top 1 * from [Product Image] where proId=?";
        ProductImage p = new ProductImage();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setProID(rs.getInt("proID"));
                p.setProImg(rs.getString("proImg"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }
    
    
    public int getIDTop1Product(){
        String sql = "select top 1 [Order Detail].stockID\n" +
"from Stock inner join [Order Detail] on Stock.stockID = [Order Detail].StockID\n" +
"group by [Order Detail].StockID\n" +
"order by sum([Order Detail].quantity) desc";
        int stockID=0, proID =0;
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                stockID = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        String sql2="select Stock.proID from Stock where stockID = "+stockID;
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql2);
            rs = st.executeQuery();
            while (rs.next()) {
                proID = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return proID;
    }
    
    public List<ComboList> getNewCombo() {
       List<ComboList> list = new ArrayList<>();
        String query = "select top 1 * from Combo order by Combo.comboID desc";
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
    
    public List<ComboList> seachComboByName(String txt){
        List<ComboList> list = new ArrayList<>();
        String query = "select * from Combo\n"
                +"where comboName like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
             ps.setString(1,"%" +txt +"%");
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
    
    public static void main(String[] args) {
          SaleDAO dao = new SaleDAO();
          List<ComboList> list = new ArrayList<>();
          list = dao.seachComboByName("mo");
          for (ComboList ComboList : list) {
              System.out.println(ComboList);
          }
          System.out.println(list.size());
    }
}
