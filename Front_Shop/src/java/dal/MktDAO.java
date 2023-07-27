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
import models.Categories;
import models.Color;
import models.Post;
import models.Product;
import models.Size;
import models.Stock;

/**
 *
 * @author dinhd513
 */
public class MktDAO {

    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;    // keet qua tra ve

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

    public int getTotalOfStock() {
        String sql = "select COUNT(*) from Stock";
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

    public int getTotalOfPost() {
        String sql = "select COUNT(*) from Post";
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

    public List<Product> getAllProduct() {
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

    public List<Categories> getAllCategories() {
        List<Categories> list = new ArrayList<>();
        String sql = "select * from Categories";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categories c = new Categories();
                c.setCaID(rs.getInt("caID"));
                c.setCaName(rs.getString("caName"));
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> pagingAllProduct(int index) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product order by proID offset ? rows fetch next 6 rows only ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 6);
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

    public List<Stock> pagingAllStock(int index) {
        List<Stock> list = new ArrayList<>();
        String query = "select * from Stock order by stockID offset ? rows fetch next 10 rows only ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Stock(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getBoolean(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Stock> get5NewStock() {
        List<Stock> list = new ArrayList<>();
        String query = "select top 5 * from Stock order by stockID DESC ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Stock(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getBoolean(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Stock> getStock(int proID) {
        List<Stock> list = new ArrayList<>();
        String query = "select * from Stock where proID = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, proID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Stock(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getBoolean(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Stock findStock(int proID, int size, int color) {

        String query = "select * from Stock where proID = ? and proSizeID = ? and proColorID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, proID);
            ps.setInt(2, size);
            ps.setInt(3, color);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Stock(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getBoolean(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Color> getAllColor() {
        List<Color> list = new ArrayList<>();
        String sql = "select * from Color order by proColorName";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Color c = new Color();
                c.setProColorID(rs.getInt("proColorID"));
                c.setProColorName(rs.getString("proColorName"));
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Size> getAllSize() {
        List<Size> list = new ArrayList<>();
        String sql = "select * from Size";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Size c = new Size();
                c.setSizeID(rs.getInt("sizeID"));
                c.setSizeName(rs.getString("sizeName"));
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getListByPageNewWithTxt(int index, String txt) {
        List<Product> list = new ArrayList<>();
        String sql;
        if ("".equals(txt)) {
            sql = "select * from Product order by proID OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        } else {
            sql = "select * from Product where proName like ? order by proID OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if ("".equals(txt)) {
                ps.setInt(1, (index - 1) * 6);
            } else {
                ps.setString(1, "%" + txt + "%");
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

    public List<Stock> getStockBySizePageNomal(int index, int sizeID) {
        List<Stock> list = new ArrayList<>();
        String sql;
        if (sizeID == 0) {
            sql = "select * from Stock order by stockID OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        } else {
            sql = "select * from Stock where proSizeID = ? order by stockID OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (sizeID == 0) {
                ps.setInt(1, (index - 1) * 10);
            } else {
                ps.setInt(1, sizeID);
                ps.setInt(2, (index - 1) * 10);
            }

            rs = ps.executeQuery();
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
        return list;
    }

    public List<Stock> getStockBySizePageNomalWithTxt(int index, int sizeID, String txt) {
        List<Stock> list = new ArrayList<>();
        String sql;
        if (sizeID == 0) {
            sql = "SELECT s.stockID, p.proID, s.proColorID,s.proSizeID,s.quantity,s.stockStatus\n"
                    + "FROM stock s\n"
                    + "JOIN product p ON s.proID = p.proID\n"
                    + "WHERE p.proName LIKE ? \n"
                    + "order by stockID OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        } else {
            sql = "SELECT s.stockID, p.proID, s.proColorID,s.proSizeID,s.quantity,s.stockStatus\n"
                    + "FROM stock s\n"
                    + "JOIN product p ON s.proID = p.proID\n"
                    + "WHERE p.proName LIKE ? and s.proSizeID=?\n"
                    + "order by stockID OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (sizeID == 0) {
                ps.setString(1, "%" + txt + "%");
                ps.setInt(2, (index - 1) * 10);
            } else {
                ps.setString(1, "%" + txt + "%");
                ps.setInt(2, sizeID);
                ps.setInt(3, (index - 1) * 10);
            }

            rs = ps.executeQuery();
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
        return list;
    }

    public List<Stock> getStockBySizePageASCWithTxt(int index, int sizeID, String txt) {
        List<Stock> list = new ArrayList<>();
        String sql;
        if (sizeID == 0) {
            sql = "SELECT s.stockID, p.proID, s.proColorID,s.proSizeID,s.quantity,s.stockStatus\n"
                    + "FROM stock s\n"
                    + "JOIN product p ON s.proID = p.proID\n"
                    + "WHERE p.proName LIKE ? \n"
                    + "order by stockID OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        } else {
            sql = "SELECT s.stockID, p.proID, s.proColorID,s.proSizeID,s.quantity,s.stockStatus\n"
                    + "FROM stock s\n"
                    + "JOIN product p ON s.proID = p.proID\n"
                    + "WHERE p.proName LIKE ? and s.proSizeID=?\n"
                    + "order by quantity ASC OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (sizeID == 0) {
                ps.setString(1, "%" + txt + "%");
                ps.setInt(2, (index - 1) * 10);
            } else {
                ps.setString(1, "%" + txt + "%");
                ps.setInt(2, sizeID);
                ps.setInt(3, (index - 1) * 10);
            }

            rs = ps.executeQuery();
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
        return list;
    }

    public List<Stock> getStockBySizePageDESCWithTxt(int index, int sizeID, String txt) {
        List<Stock> list = new ArrayList<>();
        String sql;
        if (sizeID == 0) {
            sql = "SELECT s.stockID, p.proID, s.proColorID,s.proSizeID,s.quantity,s.stockStatus\n"
                    + "FROM stock s\n"
                    + "JOIN product p ON s.proID = p.proID\n"
                    + "WHERE p.proName LIKE ? \n"
                    + "order by stockID OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        } else {
            sql = "SELECT s.stockID, p.proID, s.proColorID,s.proSizeID,s.quantity,s.stockStatus\n"
                    + "FROM stock s\n"
                    + "JOIN product p ON s.proID = p.proID\n"
                    + "WHERE p.proName LIKE ? and s.proSizeID=?\n"
                    + "order by quantity DESC OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (sizeID == 0) {
                ps.setString(1, "%" + txt + "%");
                ps.setInt(2, (index - 1) * 10);
            } else {
                ps.setString(1, "%" + txt + "%");
                ps.setInt(2, sizeID);
                ps.setInt(3, (index - 1) * 10);
            }

            rs = ps.executeQuery();
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
        return list;
    }

    public List<Product> getListByPageASCWithTxt(int index, String txt) {
        List<Product> list = new ArrayList<>();
        String sql;
        if ("".equals(txt)) {
            sql = "select * from Product order by proPrice ASC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        } else {
            sql = "select * from Product where proName like ? order by proPrice ASC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if ("".equals(txt)) {
                ps.setInt(1, (index - 1) * 6);
            } else {
                ps.setString(1, "%" + txt + "%");
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

    public List<Stock> getStockBySizePageASC(int index, int sizeID) {
        List<Stock> list = new ArrayList<>();
        String sql;
        if (sizeID == 0) {
            sql = "select * from Stock order by quantity ASC OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        } else {
            sql = "select * from Stock where proSizeID = ? order by quantity ASC OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (sizeID == 0) {
                ps.setInt(1, (index - 1) * 10);
            } else {
                ps.setInt(1, sizeID);
                ps.setInt(2, (index - 1) * 10);
            }
            rs = ps.executeQuery();
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
        return list;
    }

    public List<Stock> getStockBySizePageDESC(int index, int sizeID) {
        List<Stock> list = new ArrayList<>();
        String sql;
        if (sizeID == 0) {
            sql = "select * from Stock order by quantity DESC OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        } else {
            sql = "select * from Stock where proSizeID = ? order by quantity DESC OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (sizeID == 0) {
                ps.setInt(1, (index - 1) * 10);
            } else {
                ps.setInt(1, sizeID);
                ps.setInt(2, (index - 1) * 10);
            }
            rs = ps.executeQuery();
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
        return list;
    }

    public List<Product> getListByPageDESCWithTxt(int index, String txt) {
        List<Product> list = new ArrayList<>();
        String sql;
        if ("".equals(txt)) {
            sql = "select * from Product order by proPrice DESC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        } else {
            sql = "select * from Product where proName like ? order by proPrice DESC OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if ("".equals(txt)) {
                ps.setInt(1, (index - 1) * 6);
            } else {
                ps.setString(1, "%" + txt + "%");
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

    public int getMaxIndex(String txt) {
        int max = 0;
        Product p = new Product();
        String sql;
        if ("".equals(txt)) {
            sql = "select count(proID) from Product";
        } else {
            sql = "select count(proID) from Product where proName like ?";
        }

        try {

            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            if (!"".equals(txt)) {
                st.setString(1, "%" + txt + "%");
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

    public int getMaxIndexSize(int sizeID) {
        int max = 0;
        Product p = new Product();
        String sql;
        if (sizeID == 0) {
            sql = "select count(stockID) from Stock";
        } else {
            sql = "select count(stockID) from Stock where proSizeID = ?";
        }

        try {

            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            if (sizeID != 0) {
                st.setInt(1, sizeID);
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

    public int getMaxIndexSizeWithTxt(int sizeID, String txt) {
        int max = 0;
        Product p = new Product();
        String sql;
        if (sizeID == 0) {
            sql = "SELECT COUNT(s.stockID)\n"
                    + "FROM stock s\n"
                    + "JOIN product p ON s.proID = p.proID\n"
                    + "WHERE p.proName LIKE ?";
        } else {
            sql = "SELECT COUNT(s.stockID)\n"
                    + "FROM stock s\n"
                    + "JOIN product p ON s.proID = p.proID\n"
                    + "WHERE p.proName LIKE ? and s.proSizeID=?";
        }

        try {

            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            if (sizeID == 0) {
                st.setString(1, "%" + txt + "%");
            } else {
                st.setString(1, "%" + txt + "%");
                st.setInt(2, sizeID);
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

    public Product getProduct(String proName, int caId, float proPrice) {
        String sql = "SELECT * FROM Product where proName like ? and caID = ? and proPrice = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + proName + "%");
            ps.setInt(2, caId);
            ps.setFloat(3, proPrice);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProID(rs.getInt("proID"));
                p.setProName(rs.getString("proName"));
                p.setProDetail(rs.getString("proDetail"));
                p.setProPrice(rs.getFloat("proPrice"));
                p.setCaID(rs.getInt("caID"));
                p.setProStatus(rs.getBoolean("proStatus"));
                return p;
            }
        } catch (Exception e) {
        }
        return null;

    }

    public Product getProductNotCurrent(String proName, int caId, float proPrice, int id) {
        String sql = "SELECT * FROM Product where proName like ? and caID = ? and proPrice = ? and proID != ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + proName + "%");
            ps.setInt(2, caId);
            ps.setFloat(3, proPrice);
            ps.setInt(4, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProID(rs.getInt("proID"));
                p.setProName(rs.getString("proName"));
                p.setProDetail(rs.getString("proDetail"));
                p.setProPrice(rs.getFloat("proPrice"));
                p.setCaID(rs.getInt("caID"));

                p.setProStatus(rs.getBoolean("proStatus"));
                return p;
            }
        } catch (Exception e) {
        }
        return null;

    }

    public Product getProduct(int proID) {
        String sql = "SELECT * FROM Product where proID = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, proID);

            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProID(rs.getInt("proID"));
                p.setProName(rs.getString("proName"));
                p.setProDetail(rs.getString("proDetail"));
                p.setProPrice(rs.getFloat("proPrice"));
                p.setCaID(rs.getInt("caID"));
                p.setProStatus(rs.getBoolean("proStatus"));
                return p;
            }
        } catch (Exception e) {
        }
        return null;

    }

    public Product getNewProduct() {
        String sql = "Select  top 1 * from Product order by proID DESC";
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
                return p;
            }
        } catch (Exception e) {
        }
        return null;

    }

    public List<Product> get5NewProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "Select  top 5 * from Product order by proID DESC";
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
        }
        return list;

    }

    public List<Post> get5NewPost() {
        List<Post> list = new ArrayList<>();
        String sql = "select top 5 * from Post order by date Desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setTittle(rs.getString("tittle"));
                p.setGmail(rs.getString("gmail"));
                p.setToppic(rs.getString("toppic"));
                p.setImg(rs.getString("img"));
                p.setDetail(rs.getString("detail"));
                p.setDob(rs.getDate("date"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;

    }

    public void AddProduct(String name, String detail, float price, int caId, boolean proStatus) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([proName]\n"
                + "           ,[proDetail]\n"
                + "           ,[proPrice]\n"
                + "           ,[caID]\n"
                + "           ,[proStatus])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, detail);
            ps.setFloat(3, price);
            ps.setInt(4, caId);
            ps.setBoolean(5, proStatus);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public void addProductImg(int proID, String proImg) {
        String sql;
        boolean check = true;
        if (proImg.equals("")) {
            check = false;
        }
        if (check) {
            sql = "INSERT INTO [dbo].[Product Image]\n"
                    + "           ([proID]\n"
                    + "           ,[proImg])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, proID);
                ps.setString(2, "img/" + proImg);
                rs = ps.executeQuery();
            } catch (Exception e) {
            }
        }

    }

    public void addCategory(String caName) {

        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([caName])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, caName);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public void addStock(int proID, int color, int size, int quantity, boolean status) {

        String sql = "INSERT INTO [dbo].[Stock]\n"
                + "           ([proID]\n"
                + "           ,[proColorID]\n"
                + "           ,[proSizeID]\n"
                + "           ,[quantity]\n"
                + "           ,[stockStatus])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, proID);
            ps.setInt(2, color);
            ps.setInt(3, size);
            ps.setInt(4, quantity);
            ps.setBoolean(5, status);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public void addNewColor(String name) {
        String sql = "INSERT INTO [dbo].[Color]\n"
                + "           ([proColorName])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public Color getNewColor() {
        String sql = "Select top 1 * from Color order by proColorID DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Color(rs.getInt(1), rs.getString(2));

            }
        } catch (Exception e) {
        }
        return null;
    }

    public Categories getCategory() {
        String sql = "Select  top 1 * from Categories order by caID DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categories p = new Categories();
                p.setCaID(rs.getInt("caID"));
                p.setCaName(rs.getString("caName"));
                return p;
            }
        } catch (Exception e) {
        }
        return null;

    }

    public void UpdateProduct(int id, String name, String detail, float price, int caId, boolean status) {
        String sql = "UPDATE Product\n"
                + "SET proName = ?, proDetail = ?, proPrice = ? , caID = ?, proStatus =?\n"
                + "WHERE proID = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, detail);
            ps.setFloat(3, price);
            ps.setInt(4, caId);
            ps.setBoolean(5, status);
            ps.setInt(6, id);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public void UpdateStock(int stockID, int quantity) {
        String sql = "UPDATE Stock\n"
                + "SET quantity =?\n"
                + "WHERE stockID = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, stockID);

            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    public void UpdateStockStatus(int stockID, boolean status) {
        String sql = "UPDATE Stock\n"
                + "SET stockStatus = ?\n"
                + "WHERE stockID = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, status);
            ps.setInt(2, stockID);

            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public void DeleteProductImg(int id) {
        String sql = "DELETE FROM [dbo].[Product Image]\n"
                + "      WHERE proID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        MktDAO dao = new MktDAO();
//        List<Post> list = dao.get5NewPost();
//        for (Post size : list) {
//            System.out.println(size.getTittle());
//        }
//        dao.addProductImg(56, "");
//        Product a;
//        a = dao.getNewProduct();
//        System.out.println(a.getProName());
//        dao.UpdateProduct(61, "Do", "ok", 1, 1, true);
//        dao.addProductImg(61, "okok");
//        dao.addStock(1, 1, 4, 2, true);

//        System.out.println(dao.findStock(1, 1, 1).getProID());
        dao.UpdateStock(1, 20);
        
    }

}
