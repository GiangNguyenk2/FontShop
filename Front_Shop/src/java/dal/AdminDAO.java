package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.ShopInfo;

/**
 *
 * @author Asus
 */
public class AdminDAO {

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

    public int getTotalOfOrder() {
        String sql = "select COUNT(*) from [Order Detail]";
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

    public int getTotalOfRevenue() {
        String sql = "select SUM(o.totalMoney) from [Order] o where o.orStatusID = 4";
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

    public List<Integer> getOrderCountsByMonth(int selectedYear) {
        List<Integer> orderCounts = new ArrayList<>();

        try {
            conn = new DBContext().getConnection();
            String query = "SELECT MONTH(orDate) As Month, COUNT(*) AS TotalOrders, COUNT(CASE WHEN orStatusID = 4 THEN 1 END) AS SalesOrders \n"
                    + "                                           FROM [Order] \n"
                    + "                                            WHERE YEAR(orDate) = ? \n"
                    + "                                          GROUP BY MONTH(orDate) \n"
                    + "                                          ORDER BY MONTH(orDate)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, selectedYear);
            rs = ps.executeQuery();

            while (rs.next()) {
                int month = rs.getInt(1);
                int totalOrders = rs.getInt(2);
                int salesOrders = rs.getInt(3);

                orderCounts.add(totalOrders);
                orderCounts.add(salesOrders);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ nếu cần
        } finally {
            closeConnection();
        }
        return orderCounts;
    }

    public Map<String, Double> getTotalMoneyByMonth(int selectedYear) {
        Map<String, Double> totalMoneyMap = new HashMap<>();
        String query = "SELECT MONTH(orDate) AS month, SUM(totalMoney) AS totalMoney FROM [Order] WHERE YEAR(orDate) = ? and orStatusID = 4 GROUP BY MONTH(orDate)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
             ps.setInt(1, selectedYear);
            rs = ps.executeQuery();
            while (rs.next()) {
                int month = rs.getInt("month");
                double totalMoney = rs.getDouble("totalMoney");
                totalMoneyMap.put(String.valueOf(month), totalMoney);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalMoneyMap;
    }

    

    public ShopInfo getAllInfo() {
        String query = "select * from [Shop Information]";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ShopInfo(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void UpdateInfo(String address, String facebook, String gmail, String phone, String name) {
        String query = "UPDATE [Shop Information] SET [Address] = ?, [Facebook] = ?, [Gmail] = ?, [Phone] = ? WHERE [Name] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, address);
            ps.setString(2, facebook);
            ps.setString(3, gmail);
            ps.setString(4, phone);
            ps.setString(5, name);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}