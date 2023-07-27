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
import models.Product;

/**
 *
 * @author ACER
 */
public class ProductDAO {

    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;    // keet qua tra ve

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProID(rs.getInt("proID"));
                p.setProName(rs.getString("proName"));
                p.setProDetail(rs.getString("proDetail"));
                p.setProPrice(rs.getFloat("proPrice"));
                p.setCaID(rs.getInt("caID"));
                p.setProStatus(rs.getBoolean("proStatus"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductByCategory(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product where caID=?";
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProID(rs.getInt("proID"));
                p.setProName(rs.getString("proName"));
                p.setProDetail(rs.getString("proDetail"));
                p.setProPrice(rs.getFloat("proPrice"));
                p.setCaID(rs.getInt("caID"));
                p.setProStatus(rs.getBoolean("proStatus"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductForHome() {
        List<Product> list = new ArrayList<>();
        String sql = "select top 16 * from Product where proStatus = 1 order by proID DESC ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProID(rs.getInt("proID"));
                p.setProName(rs.getString("proName"));
                p.setProDetail(rs.getString("proDetail"));
                p.setProPrice(rs.getFloat("proPrice"));
                p.setCaID(rs.getInt("caID"));
                p.setProStatus(rs.getBoolean("proStatus"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> get4ProductByCategory(int caid, int proid) {
        List<Product> list = new ArrayList<>();
        String sql = "select top 4 * from Product where caID=? and proID!=?";
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, caid);
            st.setInt(2, proid);
            rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProID(rs.getInt("proID"));
                p.setProName(rs.getString("proName"));
                p.setProDetail(rs.getString("proDetail"));
                p.setProPrice(rs.getFloat("proPrice"));
                p.setCaID(rs.getInt("caID"));
                p.setProStatus(rs.getBoolean("proStatus"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    
    
    public Product getProductByID(int id) {
        List<Product> list = new ArrayList<>();
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

    public List<Product> getListByPageNew(int index, int caid) {
        List<Product> list = new ArrayList<>();
        String sql;
        if (caid == 0) {
            sql = "select * from Product order by proID OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        } else {
            sql = "select * from Product where caID = ? order by proID OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (caid == 0) {
                ps.setInt(1, (index - 1) * 6);
            } else {
                ps.setInt(1, caid);
                ps.setInt(2, (index - 1) * 6);
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProID(rs.getInt("proID"));
                p.setProName(rs.getString("proName"));
                p.setProDetail(rs.getString("proDetail"));
                p.setProPrice(rs.getFloat("proPrice"));
                p.setCaID(rs.getInt("caID"));
                p.setProStatus(rs.getBoolean("proStatus"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Feedback> feedbackForDetail(int proId){
        List<Feedback> list = new ArrayList<>();
         String sql = "select * from Product where proID = ?;";
         try{
             
         }catch(Exception ex){
             System.out.println(ex);
         }
        return list;
        
    }
    
    public List<Product> getListByPageASC(int index, int caid) {
        List<Product> list = new ArrayList<>();
        String sql;
        if (caid == 0) {
            sql = "select * from Product order by proPrice ASC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        } else {
            sql = "select * from Product where caID = ? order by proPrice ASC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (caid == 0) {
                ps.setInt(1, (index - 1) * 6);
            } else {
                ps.setInt(1, caid);
                ps.setInt(2, (index - 1) * 6);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProID(rs.getInt("proID"));
                p.setProName(rs.getString("proName"));
                p.setProDetail(rs.getString("proDetail"));
                p.setProPrice(rs.getFloat("proPrice"));
                p.setCaID(rs.getInt("caID"));
                p.setProStatus(rs.getBoolean("proStatus"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getListByPageDESC(int index, int caid) {
        List<Product> list = new ArrayList<>();
        String sql;
        if (caid == 0) {
            sql = "select * from Product order by proPrice DESC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        } else {
            sql = "select * from Product where caID = ? order by proPrice DESC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (caid == 0) {
                ps.setInt(1, (index - 1) * 6);
            } else {
                ps.setInt(1, caid);
                ps.setInt(2, (index - 1) * 6);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProID(rs.getInt("proID"));
                p.setProName(rs.getString("proName"));
                p.setProDetail(rs.getString("proDetail"));
                p.setProPrice(rs.getFloat("proPrice"));
                p.setCaID(rs.getInt("caID"));
                p.setProStatus(rs.getBoolean("proStatus"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //search 
    public List<Product> search(String key, int page) {
        List<Product> list = new ArrayList<>();
        String[] k = key.split("\\s");
        String sql = "select * from Product where 1=1 ";
        String mainKey= "";
        if (k.length > 1) {
            for (int i = 0; i < k.length; i++) {
                    mainKey += "%" + k[i] + "%"; 
            }
        } else {
            mainKey += "%"+key+"%";
        }
        try {
            if (key != null) {
                //sql += "and proName like '%" + key + "%' or proDetail like '%" + key + "%'" + " or proPrice like '%" + key + "%'" +" order by proID OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
                sql += "and proName like '"+mainKey+"' or proDetail like '" + mainKey + "' or proPrice like '" + mainKey + "' order by proID OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
                conn = new DBContext().getConnection();
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1, (page - 1) * 6);
                rs = st.executeQuery();
                while (rs.next()) {
                    Product p = new Product();
                    p.setProID(rs.getInt("proID"));
                    p.setProName(rs.getString("proName"));
                    p.setProDetail(rs.getString("proDetail"));
                    p.setProPrice(rs.getFloat("proPrice"));
                    p.setCaID(rs.getInt("caID"));
                    p.setProStatus(rs.getBoolean("proStatus"));
                    list.add(p);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getMaxIndexSearch(String key) {
        int max = 0;
        Product p = new Product();
        String sql = "select count(proID) from Product where proName like '%" + key + "%' or proDetail like '%" + key + "%'" + " or proPrice like '%" + key + "%'";

        try {

            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                max = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return max;
    }

    public int getMaxIndex(int caid) {
        int max = 0;
        Product p = new Product();
        String sql;
        if (caid == 0) {
            sql = "select count(proID) from Product";
        } else {
            sql = "select count(proID) from Product where caID=?";
        }

        try {

            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            if (caid != 0) {
                st.setInt(1, caid);
            }
            rs = st.executeQuery();
            while (rs.next()) {
                max = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return max;
    }

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        ProductDAO pidb = new ProductDAO();
//        list = pidb.getListByPageNew(4, 0);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getProID());
//        }
        list = pidb.search("RD Tshirt", 1);
       
        for (Product product : list) {
            
            System.out.println(product.getProName());
        }
    }
}
