/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.Account;
import models.Address;
import models.Cart;
import models.Item;
import models.Order;
import models.OrderDetail;
import models.Status;
import models.StockDetail;

/**
 *
 * @author ACER
 */
public class OrderDAO {

    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;    // keet qua tra ve

    public void addOrder(Account acc, Cart cart, List<StockDetail> stock, int addID) {
        LocalDate curDate = LocalDate.now();

        String date = curDate.toString();

        try {
            //add order
            String sql = "INSERT INTO [dbo].[Order]\n"
                    + "           ([orDate]\n"
                    + "           ,[gmail]\n"
                    + "           ,[totalMoney]\n"
                    + "           ,[orStatusID]\n"
                    + "           ,[addID])"
                    + "     VALUES(?,?,?,?,?);";
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, date);
            st.setString(2, acc.getGmail());
            st.setDouble(3, cart.getTotalMoney());
            st.setInt(4, 1);
            st.setInt(5, addID);
            st.executeUpdate();

            String sql1 = "select top 1 orID from [Order] order by orID DESC";
            PreparedStatement st1 = conn.prepareStatement(sql1);
            ResultSet rs1 = st1.executeQuery();

            if (rs1.next()) {
                int oid = rs1.getInt("orID");
                for (Item i : cart.getItems()) {
                    for (StockDetail s : stock) {
                        if (i.getProduct().getProID() == s.getProID() && i.getColorID() == s.getProColorID() && i.getSizeID() == s.getProSizeID()) {
                            String sql2 = "INSERT INTO [dbo].[Order Detail]\n"
                                    + "           ([orID]\n"
                                    + "           ,[stockID]\n"
                                    + "           ,[quantity]\n"
                                    + "           ,[price])\n"
                                    + "     VALUES (?,?,?,?); ";
                            conn = new DBContext().getConnection();
                            PreparedStatement st2 = conn.prepareStatement(sql2);
                            st2.setInt(1, oid);
                            st2.setInt(2, s.getStockID());
                            st2.setInt(3, i.getQuantity());
                            st2.setDouble(4, i.getPrice());
                            st2.executeUpdate();
                        }
                    }

                }
            }
            // cap nhat lai so luong san pham

//            } 
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void addOrderNewAddress(Account acc, Cart cart, List<StockDetail> stock,
            String tinh, String huyen, String xa, String nha, String phone) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {

            String sql5 = "INSERT INTO [dbo].[Address]\n"
                    + "           ([gmail]\n"
                    + "           ,[phone]\n"
                    + "           ,[address]\n"
                    + "           ,[city]\n"
                    + "           ,[district]\n"
                    + "           ,[ward])\n"
                    + "     VALUES (?,?,?,?,?,?);";
            try {
                conn = new DBContext().getConnection();
                PreparedStatement st = conn.prepareStatement(sql5);
                st.setString(1, acc.getGmail());
                st.setString(2, phone);
                st.setString(3, nha);
                st.setString(4, tinh);
                st.setString(5, huyen);
                st.setString(6, xa);
                st.executeUpdate();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            String sql6 = "select top 1 addID from [Address] order by addID DESC";
            PreparedStatement st6 = conn.prepareStatement(sql6);
            ResultSet rs6 = st6.executeQuery();
            if (rs6.next()) {
                int aid = rs6.getInt("addID");
                //add order
                String sql = "INSERT INTO [dbo].[Order]\n"
                        + "        ([orDate]\n"
                        + "           ,[gmail]\n"
                        + "           ,[totalMoney]\n"
                        + "           ,[orStatusID]\n"
                        + "           ,[addID])   " + "VALUES(?,?,?,?,?);";

                conn = new DBContext().getConnection();
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, date);
                st.setString(2, acc.getGmail());
                st.setDouble(3, cart.getTotalMoney());
                st.setInt(4, 1);
                st.setInt(5, aid);
                st.executeUpdate();
            }

            String sql1 = "select top 1 orID from [Order] order by orID DESC";
            PreparedStatement st1 = conn.prepareStatement(sql1);
            ResultSet rs1 = st1.executeQuery();
            if (rs1.next()) {
                int oid = rs1.getInt("orID");
                for (Item i : cart.getItems()) {
                    for (StockDetail s : stock) {
                        if (i.getProduct().getProID() == s.getProID() && i.getColorID() == s.getProColorID() && i.getSizeID() == s.getProSizeID()) {
                            String sql2 = "INSERT INTO [dbo].[Order Detail]\n"
                                    + "           ([orID]\n"
                                    + "           ,[stockID]\n"
                                    + "           ,[quantity]\n"
                                    + "           ,[price])\n"
                                    + "     VALUES (?,?,?,?); ";
                            conn = new DBContext().getConnection();
                            PreparedStatement st2 = conn.prepareStatement(sql2);
                            st2.setInt(1, oid);
                            st2.setInt(2, s.getStockID());
                            st2.setInt(3, i.getQuantity());
                            st2.setDouble(4, i.getPrice());
                            st2.executeUpdate();
                        }
                    }

                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public List<Order> getOrder(int index, String type, String filter) {
        List<Order> list = new ArrayList<>();
        String sql = "";
        //all
        if (type.equals("all") && filter.equals("new")) {
            sql = "select * from [Order] order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("all") && filter.equals("high")) {
            sql = "select * from [Order] order by orID  DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("all") && filter.equals("low")) {
            sql = "select * from [Order] order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        //submit
        if (type.equals("Pending") && filter.equals("new")) {
            sql = "select * from [Order] where orStatusID = 1 order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("Pending") && filter.equals("high")) {
            sql = "select * from [Order] where orStatusID = 1 order by orID DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("Pending") && filter.equals("low")) {
            sql = "select * from [Order] where orStatusID = 1 order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        //comfirm
        if (type.equals("Confirmed") && filter.equals("new")) {
            sql = "select * from [Order] where orStatusID = 2 order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("Confirmed") && filter.equals("high")) {
            sql = "select * from [Order] where orStatusID = 2 order by orID DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("Confirmed") && filter.equals("low")) {
            sql = "select * from [Order] where orStatusID = 2 order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        //ship
        if (type.equals("Shipping") && filter.equals("new")) {
            sql = "select * from [Order] where orStatusID = 3 order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("Shipping") && filter.equals("high")) {
            sql = "select * from [Order] where orStatusID = 3 order by orID DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("Shipping") && filter.equals("low")) {
            sql = "select * from [Order] where orStatusID = 3 order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        //done
        if (type.equals("Complete") && filter.equals("new")) {
            sql = "select * from [Order] where orStatusID = 4 order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("Complete") && filter.equals("high")) {
            sql = "select * from [Order] where orStatusID = 4 order by orID DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("Complete") && filter.equals("low")) {
            sql = "select * from [Order] where orStatusID = 4 order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        //cancel
        if (type.equals("Canceled") && filter.equals("new")) {
            sql = "select * from [Order] where orStatusID = 5 order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("Canceled") && filter.equals("high")) {
            sql = "select * from [Order] where orStatusID = 5 order by orID DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (type.equals("Canceled") && filter.equals("low")) {
            sql = "select * from [Order] where orStatusID = 5 order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 12);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order p = new Order();
                p.setOrID(rs.getInt("orID"));
                p.setOrDate(rs.getString("orDate"));
                p.setGmail(rs.getString("gmail"));
                p.setTotalMoney(rs.getDouble("totalMoney"));
                p.setOrStatusID(rs.getInt("orStatusID"));
                p.setAddID(rs.getInt("addID"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Status> getNameStatus() {
        List<Status> list = new ArrayList<>();
        String sql = "SELECT [orStatusID]\n"
                + "      ,[orStatusName]\n"
                + "  FROM [dbo].[Status]";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Status p = new Status();
                p.setOrStatusID(rs.getInt("orStatusID"));
                p.setOrStatusName(rs.getString("orStatusName"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }

    public Status getNameStatusByID(int id) {
        List<Status> list = new ArrayList<>();
        String sql = "SELECT [orStatusID]\n"
                + "      ,[orStatusName]\n"
                + "  FROM [dbo].[Status] where orStatusID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Status p = new Status();
                p.setOrStatusID(rs.getInt("orStatusID"));
                p.setOrStatusName(rs.getString("orStatusName"));
                return p;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public List<Order> searchOrder(int index, String txt, String filter, String table) {
        List<Order> list = new ArrayList<>();
        String sql = "";
        //all
        if (filter.equals("new") && table.equals("all")) {
            sql = "select * from [Order] where orID like '%" + txt + "%' \n"
                    + "  order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("high") && table.equals("all")) {
            sql = "select * from [Order] where  orID like '%" + txt + "%' \n"
                    + "  order by orID DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("low") && table.equals("all")) {
            sql = "select * from [Order] where  orID like '%" + txt + "%' \n"
                    + "order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        //pending
        if (filter.equals("new") && table.equals("Pending")) {
            sql = "select * from [Order] where orStatusID = 1 and  orID like '%" + txt + "%' \n"
                    + "  order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("high") && table.equals("Pending")) {
            sql = "select * from [Order] where orStatusID = 1 and orID like '%" + txt + "%' \n"
                    + " order by orID DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("low") && table.equals("Pending")) {
            sql = "select * from [Order] where orStatusID = 1 and orID like '%" + txt + "%' \n"
                    + "  order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        //confirm
        if (filter.equals("new") && table.equals("Confirmed")) {
            sql = "select * from [Order] where orStatusID = 2 and orID like '%" + txt + "%' \n"
                    + "  order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("high") && table.equals("Confirmed")) {
            sql = "select * from [Order] where orStatusID = 2 and orID like '%" + txt + "%' \n"
                    + "  order by orID DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("low") && table.equals("Confirmed")) {
            sql = "select * from [Order] where orStatusID = 2 and orID like '%" + txt + "%' \n"
                    + " order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        //shipping
        if (filter.equals("new") && table.equals("Shipping")) {
            sql = "select * from [Order] where orStatusID = 3 and orID like '%" + txt + "%'  \n"
                    + "  order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("high") && table.equals("Shipping")) {
            sql = "select * from [Order] where orStatusID = 3 and orID like '%" + txt + "%' \n"
                    + "  order by orID DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("low") && table.equals("Shipping")) {
            sql = "select * from [Order] where orStatusID = 3 and orID like '%" + txt + "%' \n"
                    + "  order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        //complete
        if (filter.equals("new") && table.equals("Complete")) {
            sql = "select * from [Order] where orStatusID = 4 and orID like '%" + txt + "%' \n"
                    + "  order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("high") && table.equals("Complete")) {
            sql = "select * from [Order] where orStatusID = 4 and orID like '%" + txt + "%' \n"
                    + "  order by orID DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("low") && table.equals("Complete")) {
            sql = "select * from [Order] where orStatusID = 4 and orID like '%" + txt + "%' \n"
                    + "  order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        //cancel
        if (filter.equals("new") && table.equals("Canceled")) {
            sql = "select * from [Order] where orStatusID = 5 and orID like '%" + txt + "%' \n"
                    + " order by orDate DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("high") && table.equals("Canceled")) {
            sql = "select * from [Order] where orStatusID = 5 and orID like '%" + txt + "%' \n"
                    + "  order by orID DESC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (filter.equals("low") && table.equals("Canceled")) {
            sql = "select * from [Order] where orStatusID = 5 and orID like '%" + txt + "%' \n"
                    + " order by orID ASC OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 12);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order p = new Order();
                p.setOrID(rs.getInt("orID"));
                p.setOrDate(rs.getString("orDate"));
                p.setGmail(rs.getString("gmail"));
                p.setTotalMoney(rs.getDouble("totalMoney"));
                p.setOrStatusID(rs.getInt("orStatusID"));
                p.setAddID(rs.getInt("addID"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Order getOrderByID(int id) {
        String sql = "select * from [Order] where orID = ?";
        Order p = new Order();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                p.setOrID(rs.getInt("orID"));
                p.setOrDate(rs.getString("orDate"));
                p.setGmail(rs.getString("gmail"));
                p.setTotalMoney(rs.getDouble("totalMoney"));
                p.setOrStatusID(rs.getInt("orStatusID"));
                p.setAddID(rs.getInt("addID"));
                return p;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<OrderDetail> getOrderDetailByID(int orID) {
        String sql = "select * from [Order Detail] where orID = ?";
        List<OrderDetail> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orID);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail p = new OrderDetail();
                p.setOrID(rs.getInt("orID"));
                p.setStockID(rs.getInt("stockID"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Address getAddressByID(int id) {
        String sql = "SELECT [addID]\n"
                + "      ,[gmail]\n"
                + "      ,[phone]\n"
                + "      ,[address]\n"
                + "      ,[city]\n"
                + "      ,[district]\n"
                + "      ,[ward]\n"
                + "  FROM [dbo].[Address] where addID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Address a = new Address();
                a.setID(rs.getInt("addID"));
                a.setGmail(rs.getString("gmail"));
                a.setPhone(rs.getString("phone"));
                a.setAddress(rs.getString("address"));
                a.setCity(rs.getString("city"));
                a.setDistrict(rs.getString("district"));
                a.setWard(rs.getString("ward"));
                return a;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateStatusOrder(Order o, int statusID) {

        String sql = "UPDATE [dbo].[Order]\n"
                + "   SET [orDate] = ?\n"
                + "      ,[gmail] = ?\n"
                + "      ,[totalMoney] = ?\n"
                + "      ,[orStatusID] = ?\n"
                + "      ,[addID] = ?\n"
                + " WHERE  orID=?";
        try {
            conn = new DBContext().getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, o.getOrDate());
            st.setString(2, o.getGmail());
            st.setDouble(3, o.getTotalMoney());
            st.setInt(4, statusID);
            st.setInt(5, o.getAddID());
            st.setInt(6, o.getOrID());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void updateStockByOrder(List<OrderDetail> o, List<StockDetail> s) {
        for (OrderDetail od : o) {
            for (StockDetail stock : s) {
                if (stock.getStockID() == od.getStockID()) {
                    String sql = "UPDATE [dbo].[Stock]\n"
                            + "   SET [proID] = ?\n"
                            + "      ,[proColorID] = ?\n"
                            + "      ,[proSizeID] = ?\n"
                            + "      ,[quantity] = ?\n"
                            + "      ,[stockStatus] = ? \n"
                            + " WHERE stockID =?";
                    try {
                        conn = new DBContext().getConnection();
                        PreparedStatement st = conn.prepareStatement(sql);
                        st.setInt(1, stock.getProID());
                        st.setInt(2, stock.getProColorID());
                        st.setInt(3, stock.getProSizeID());

                        st.setInt(4, stock.getQuantity() - od.getQuantity());
                        st.setBoolean(5, stock.getQuantity() - od.getQuantity() > 0 ? true : false);
                        st.setInt(6, od.getStockID());
                        st.executeUpdate();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }

        }

    }

    public List<Order> getOrderByDate(String table, Date sdate, Date edate, int page) {
        String sql = "";
        List<Order> list = new ArrayList<>();
        if (table.equals("all")) {
            sql = "select * from [Order] where orDate >= ? AND orDate <= ? order by orID OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (table.equals("Pending")) {
            sql = "select * from [Order] where orDate >= ? AND orDate <= ? AND orStatusID = 1 order by orID OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (table.equals("Confirmed")) {
            sql = "select * from [Order] where orDate >= ? AND orDate <= ? AND orStatusID = 2 order by orID OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (table.equals("Shipping")) {
            sql = "select * from [Order] where orDate >= ? AND orDate <= ? AND orStatusID = 3 order by orID OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }

        if (table.equals("Complete")) {
            sql = "select * from [Order] where orDate >= ? AND orDate <= ? AND orStatusID = 4 order by orID OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }
        if (table.equals("Canceled")) {
            sql = "select * from [Order] where orDate >= ? AND orDate <= ? AND orStatusID = 5 order by orID OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
        }

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setDate(1, sdate);
            ps.setDate(2, edate);
            ps.setInt(3, (page - 1) * 12);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order p = new Order();
                p.setOrID(rs.getInt("orID"));
                p.setOrDate(rs.getString("orDate"));
                p.setGmail(rs.getString("gmail"));
                p.setTotalMoney(rs.getDouble("totalMoney"));
                p.setOrStatusID(rs.getInt("orStatusID"));
                p.setAddID(rs.getInt("addID"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getOrderDoneByGmail(String gmail){
        String sql = "SELECT Count( orStatusID ) FROM [Order] where gmail = ? and orStatusID='4'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, gmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int getOrderCancelByGmail(String gmail){
        String sql = "SELECT Count( orStatusID ) FROM [Order] where gmail = ? and orStatusID='5'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, gmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int getTotalMoneyDone(String gmail){
        String sql = "SELECT Sum( totalMoney ) FROM [Order] where gmail = ? and orStatusID='4'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, gmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
        }
        return 0;
    }
    
}
