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
import models.Product;
import models.ProductImage;

/**
 *
 * @author ACER
 */
public class ProductImageDAO {

    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;    // keet qua tra ve

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

    public List<ProductImage> getImagetop1() {
        List<ProductImage> list = new ArrayList<>();
        String sql = "select top 1 * from [Product Image]";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductImage(rs.getInt(1),
                        rs.getString(2))
                );
            }
        } catch (Exception e) {

        }
        return list;

    }

    public List<ProductImage> getImageByProductId(int id) {
        List<ProductImage> list = new ArrayList<>();
        String sql = "select * from [Product Image] where proID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductImage p = new ProductImage();
                p.setProID(rs.getInt("proID"));
                p.setProImg(rs.getString("proImg"));
                list.add(p);

            }
        } catch (Exception e) {

        }
        return list;
    }

    //lay 1 anh trong list quan ao
    public List<ProductImage> getListImageByProductId(List<Product> list1) {
        List<ProductImage> list = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            String sql = "select top 1 * from [Product Image] where proID=?";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, list1.get(i).getProID());
                rs = ps.executeQuery();
                while (rs.next()) {
                    ProductImage p = new ProductImage();
                    p.setProID(rs.getInt("proID"));
                    p.setProImg(rs.getString("proImg"));
                    list.add(p);

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        ProductImageDAO d = new ProductImageDAO();
        List<ProductImage> list_img = new ArrayList<>();
            list_img.add(d.getImageById(1));
            list_img.add(d.getImageById(1));
            list_img.add(d.getImageById(2));
            list_img.add(d.getImageById(2));
            list_img.add(d.getImageById(2));
            list_img.add(d.getImageById(1));
            list_img.add(d.getImageById(3));
            list_img.add(d.getImageById(1));
            list_img.add(d.getImageById(4));
            list_img.add(d.getImageById(4));
            list_img.add(d.getImageById(4));
            list_img.add(d.getImageById(4));
            list_img.add(d.getImageById(4));
            list_img.add(d.getImageById(1));
            list_img.add(d.getImageById(2));
            list_img.add(d.getImageById(2));
            
          for (int i = 0; i < list_img.size(); i++) {
            for (int j = list_img.size()-1; j > i; j--) {
                if (list_img.get(i).getProID() == list_img.get(j).getProID()) {
                    list_img.remove(j);
                }
            }
        }
        for (int i = 0; i < list_img.size(); i++) {

            System.out.println(list_img.get(i).getProID());

        }

    }
}
