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
import models.OrderDetail;
import models.Product;
import models.Stock;
import models.StockDetail;

/**
 *
 * @author ACER
 */
public class StockDAO {

    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;    // keet qua tra ve

    public List<StockDetail> getStockProduct(int proID, int colorID) {
        List<StockDetail> list = new ArrayList<>();
        String sql = "select stockID,proID,p.proColorID,proSizeID,quantity,stockStatus,proColorName,sizeName from Stock as p, Color as c, Size as s \n"
                + "where  p.proColorID = c.proColorID and p.proSizeID = s.sizeID and p.proID=? and c.proColorID =? and p.stockStatus=1";
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, proID);
            st.setInt(2, colorID);
            rs = st.executeQuery();
            while (rs.next()) {
                StockDetail p = new StockDetail();
                p.setStockID(rs.getInt("stockID"));
                p.setProID(rs.getInt("proID"));
                p.setProColorID(rs.getInt("proColorID"));
                p.setProSizeID(rs.getInt("proSizeID"));
                p.setQuantity(rs.getInt("quantity"));
                p.setStockStatus(rs.getBoolean("stockStatus"));
                p.setProColorName(rs.getString("proColorName"));
                p.setSizeName(rs.getString("sizeName"));

                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<StockDetail> getSizeDefault(int proID ){
        List<StockDetail> list = new ArrayList<>();
        String sql = "   select  stockID,proID,p.proColorID,proSizeID,quantity,stockStatus,proColorName,sizeName from Stock as p, Color as c, Size as s \n" +
"  where p.stockStatus=1 and  p.proColorID = c.proColorID and p.proSizeID = s.sizeID and p.proID=? and p.quantity != 0 ";
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, proID);
           
            rs = st.executeQuery();
            while (rs.next()) {
                StockDetail p = new StockDetail();
                p.setStockID(rs.getInt("stockID"));
                p.setProID(rs.getInt("proID"));
                p.setProColorID(rs.getInt("proColorID"));
                p.setProSizeID(rs.getInt("proSizeID"));
                p.setQuantity(rs.getInt("quantity"));
                p.setStockStatus(rs.getBoolean("stockStatus"));
                p.setProColorName(rs.getString("proColorName"));
                p.setSizeName(rs.getString("sizeName"));

                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<StockDetail> getStockProductByColorName(int proID, String colorName) {
        List<StockDetail> list = new ArrayList<>();
        String sql = "select stockID,proID,p.proColorID,proSizeID,quantity,stockStatus,proColorName,sizeName from Stock as p, Color as c, Size as s \n"
                + "where  p.proColorID = c.proColorID and p.proSizeID = s.sizeID and p.proID=? and c.proColorName =? and p.stockStatus=1";
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, proID);
            st.setString(2, colorName);
            rs = st.executeQuery();
            while (rs.next()) {
                StockDetail p = new StockDetail();
                p.setStockID(rs.getInt("stockID"));
                p.setProID(rs.getInt("proID"));
                p.setProColorID(rs.getInt("proColorID"));
                p.setProSizeID(rs.getInt("proSizeID"));
                p.setQuantity(rs.getInt("quantity"));
                p.setStockStatus(rs.getBoolean("stockStatus"));
                p.setProColorName(rs.getString("proColorName"));
                p.setSizeName(rs.getString("sizeName"));

                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<StockDetail> getStockProductAll(int proID) {
        List<StockDetail> list = new ArrayList<>();
        String sql = "select stockID,proID,p.proColorID,proSizeID,quantity,stockStatus,proColorName,sizeName from Stock as p, Color as c, Size as s \n"
                + "where  p.proColorID = c.proColorID and p.proSizeID = s.sizeID and p.proID=? and p.stockStatus=1";
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, proID);

            rs = st.executeQuery();
            while (rs.next()) {
                StockDetail p = new StockDetail();
                p.setStockID(rs.getInt("stockID"));
                p.setProID(rs.getInt("proID"));
                p.setProColorID(rs.getInt("proColorID"));
                p.setProSizeID(rs.getInt("proSizeID"));
                p.setQuantity(rs.getInt("quantity"));
                p.setStockStatus(rs.getBoolean("stockStatus"));
                p.setProColorName(rs.getString("proColorName"));
                p.setSizeName(rs.getString("sizeName"));

                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public StockDetail getStockQuantity(int proID, int colorId, int sizeId) {
        StockDetail p = new StockDetail();
        String sql = "select stockID,proID,p.proColorID,proSizeID,quantity,stockStatus,proColorName,sizeName from Stock as p, Color as c, Size as s \n"
                + "where  p.proColorID = c.proColorID and p.proSizeID = s.sizeID and p.proID=? and c.proColorID =? and p.proSizeID= ? and p.stockStatus=1";
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, proID);
            st.setInt(2, colorId);
            st.setInt(3, sizeId);

            rs = st.executeQuery();
            while (rs.next()) {

                p.setStockID(rs.getInt("stockID"));
                p.setProID(rs.getInt("proID"));
                p.setProColorID(rs.getInt("proColorID"));
                p.setProSizeID(rs.getInt("proSizeID"));
                p.setQuantity(rs.getInt("quantity"));
                p.setStockStatus(rs.getBoolean("stockStatus"));
                p.setProColorName(rs.getString("proColorName"));
                p.setSizeName(rs.getString("sizeName"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }

    public List<Stock> getStockForShopAll(List<Product> listproduct) {
        List<Stock> list = new ArrayList<>();
        for (int i = 0; i < listproduct.size(); i++) {
            String sql = "select top 1 * from Stock where proID=? and stockStatus =1 ";
            try {
                conn = new DBContext().getConnection();
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1, listproduct.get(i).getProID());
                rs = st.executeQuery();
                while (rs.next()) {
                    Stock p = new Stock();
                    p.setStockID(rs.getInt("stockID"));
                    p.setProID(rs.getInt("proID"));
                    p.setProColorID(rs.getInt("proColorID"));
                    p.setProSizeID(rs.getInt("proSizeID"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setStockStatus(rs.getBoolean("stockStatus"));
                    list.add(p);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return list;
    }

    public StockDetail getStockForCart(int proID, int colorID, int sizeID) {

        StockDetail p = new StockDetail();
        String sql = "select stockID,proID,p.proColorID,proSizeID,quantity,stockStatus,proColorName,sizeName from Stock as p, Color as c, Size as s \n"
                + "where  p.proColorID = c.proColorID and p.proSizeID = s.sizeID and p.proID=? and c.proColorID =? and s.sizeID = ? and p.stockStatus=1";
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, proID);
            st.setInt(2, colorID);
            st.setInt(3, sizeID);

            rs = st.executeQuery();
            while (rs.next()) {

                p.setStockID(rs.getInt("stockID"));
                p.setProID(rs.getInt("proID"));
                p.setProColorID(rs.getInt("proColorID"));
                p.setProSizeID(rs.getInt("proSizeID"));
                p.setQuantity(rs.getInt("quantity"));
                p.setStockStatus(rs.getBoolean("stockStatus"));
                p.setProColorName(rs.getString("proColorName"));
                p.setSizeName(rs.getString("sizeName"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }

    public List<StockDetail> getListStockByID(List<OrderDetail> o) {

        List<StockDetail> list = new ArrayList<>();
        for (OrderDetail order : o) {
            String sql = "select stockID,proID,p.proColorID,proSizeID,quantity,stockStatus,proColorName,sizeName from Stock as p, Color as c, Size as s \n"
                    + "                where  p.proColorID = c.proColorID and p.proSizeID = s.sizeID and p.stockID = ? and p.stockStatus=1";
            try {
                conn = new DBContext().getConnection();
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1, order.getStockID());
                rs = st.executeQuery();
                while (rs.next()) {
                    StockDetail p = new StockDetail();
                    p.setStockID(rs.getInt("stockID"));
                    p.setProID(rs.getInt("proID"));
                    p.setProColorID(rs.getInt("proColorID"));
                    p.setProSizeID(rs.getInt("proSizeID"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setStockStatus(rs.getBoolean("stockStatus"));
                    p.setProColorName(rs.getString("proColorName"));
                    p.setSizeName(rs.getString("sizeName"));
                    list.add(p);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return list;
    }

    public static void main(String[] args) {
//        StockDetail list ;
        ProductDAO pdb = new ProductDAO();
        StockDAO s = new StockDAO();
        List<Stock> list1 = new ArrayList<>();
//        ProductDAO d = new ProductDAO();
//        list1 = d.getListByPageNew(1, 0);
        List<Product> list_product = pdb.getProductForHome();
       List<StockDetail> list =s.getSizeDefault(1);
        for (StockDetail stockDetail : list) {
            System.out.println(stockDetail.getProID());
        }

    }
}
