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

/**
 *
 * @author ACER
 */
public class CategoriesDAO {
    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;    // keet qua tra ve
    
    public List<Categories> getAll() {
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
    
    public static void main(String[] args)  {
        CategoriesDAO d = new CategoriesDAO();
        List<Categories> list = d.getAll();
        for(int i = 0; i < list.size();i++){
            System.out.println(list.get(i).getCaID());
        }
    }
}
