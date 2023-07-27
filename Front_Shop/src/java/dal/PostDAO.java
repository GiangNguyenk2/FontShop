/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Post;

/**
 *
 * @author DELL
 */
public class PostDAO extends DBContext {

    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;    // keet qua tra ve

    public ArrayList<Post> getAllPost() {

        ArrayList<Post> list = new ArrayList<>();
        String sql = "select * from Post";

        try {

            PreparedStatement statement = getConnection().prepareStatement(sql);// chuẩn bị sql để chạy
            ResultSet rs = statement.executeQuery(); // chạy câu query và trả về result set
            while (rs.next()) {
                Post posts = new Post(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7)); //Lấy dữ liệu theo cột
                list.add(posts);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Post getTittleByNewDate() {
        String query = " SELECT *\n"
                + "FROM Post\n"
                + "WHERE date = (SELECT MAX(date) FROM Post);";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Post(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7));

            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Post> get6NewForHome() {
        List<Post> list = new ArrayList<>();
        String query = "SELECT top 6 * FROM Post as p order by p.date desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Post p = new Post(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Post getPostByTittle(String tt) {
        String query = " select *from Post \n"
                + "  where tittle like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + tt + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Post(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7));

            }
        } catch (Exception e) {
        }
        return null;

    }

    public ArrayList<Post> getBlogByCate(String toppic) {

        ArrayList<Post> list = new ArrayList<>();
        String sql = " select * from Post where toppic = ?";

        try {

            PreparedStatement statement = getConnection().prepareStatement(sql);// chuẩn bị sql để chạy
            statement.setString(1, toppic);
            ResultSet rs = statement.executeQuery(); // chạy câu query và trả về result set

            while (rs.next()) {
                Post posts = new Post(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7)); //Lấy dữ liệu theo cột
                list.add(posts);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // dem so luong trong database
    public int getTotalPost() {
        String query = "  select count(*) from Post";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
        }

        return 0;
    }

    public List<Post> paggingPost(int index) {
        List<Post> list = new ArrayList<>();
        String query = "   select * from Post\n"
                + "  order by tittle\n"
                + "  offset ? rows fetch next 4 row only";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 4);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Post(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7)));

            }

        } catch (Exception e) {
        }

        return list;
    }

    public int getTotalToppic(String toppic) {
        String query = "   select count(*) from Post\n"
                + "				  where toppic = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, toppic);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
        }

        return 0;
    }

    public List<Post> paggingPostByToppic(int index, String toppic) {
        List<Post> list = new ArrayList<>();
        String query = "   select * from Post where toppic = ?\n "
                + "  order by tittle\n"
                + "  offset ? rows fetch next 2 row only";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, toppic);
            ps.setInt(2, (index - 1) * 2);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Post(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7)));

            }

        } catch (Exception e) {
        }

        return list;
    }

    public void deleteBlog(String dtittle) {
        String query = " delete from Post\n"
                + "  where tittle = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, dtittle);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertPost(String tittle, String gmail, String toppic, String img, String detail, String date) {
        String query = "  INSERT INTO [dbo].[Post]\n"
                + "  ([tittle],[gmail],[toppic],[img],[detail],[date]) VALUES (?,?,?,?,?,?);";

        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, tittle);
            ps.setString(2, gmail);
            ps.setString(3, toppic);
            ps.setString(4, "img/" + img);
            ps.setString(5, detail);
            ps.setString(6, date);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void updatePost(String tittle, String gmail, String toppic, String img, String detail, String date , String postID) {
        String query = " UPDATE [dbo].[Post]\n"
                + "   SET [tittle] = ? \n"
                + "      ,[gmail] = ? \n"
                + "      ,[toppic] = ? \n"
                + "      ,[img] = ? \n"
                + "      ,[detail] = ? \n"
                + "      ,[date] = ? \n"
                + " WHERE  [postID] = ?";

        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, tittle);
            ps.setString(2, gmail);
            ps.setString(3, toppic);
            ps.setString(4, "img/" + img);
            ps.setString(5, detail);
            ps.setString(6, date);
            ps.setString(7, postID);
            
            
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        PostDAO post = new PostDAO();
        post.updatePost("ha", 	"dodvhe161048@fpt.edu.vn", "News", "..img/ATB Polo_2", "Hahaha", "2023-06-08", "25");
      
    }

    
}
