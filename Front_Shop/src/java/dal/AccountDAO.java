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
import models.Account;
import models.Address;

/**
 *
 * @author dinhd513
 */
public class AccountDAO {

    Connection conn = null;        // keets noois sql
    PreparedStatement ps = null;  // nems cau lenh query
    ResultSet rs = null;    // keet qua tra ve

    public Account login(String gmail, String password) {
        String query = "select * from Account where gmail = ? and password= ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, gmail);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getInt(5),
                        rs.getBoolean(6)
                );
            }
        } catch (Exception e) {

        }
        return null;

    }

    public void AddAccount(String gmail, String password, String name, boolean gender, int roleID, boolean status) {
        String query = "INSERT INTO [dbo].[Account]\n"
                + "           ([gmail]\n"
                + "           ,[password]\n"
                + "           ,[name]\n"
                + "           ,[gender]\n"
                + "           ,[roleID]\n"
                + "           ,[accStatus])\n"
                + "     VALUES(?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, gmail);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setBoolean(4, gender);
            ps.setInt(5, roleID);
            ps.setBoolean(6, status);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void setStatusAccount(String gmail, boolean status) {
        String query = "UPDATE [dbo].[Account]\n"
                + "   SET [accStatus] = ?\n"
                + " WHERE gmail = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, status);
            ps.setString(2, gmail);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void setPasswordAccount(String gmail, String password) {
        String query = "UPDATE [dbo].[Account]\n"
                + "   SET [password] = ?\n"
                + " WHERE gmail = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, gmail);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void AddAccountAddress(String gmail, String phone, String address) {
        String query = "insert into AccountAddress values(?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, gmail);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account searchAccByID(String gmail) {
        String query = "select * from Account where gmail = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, gmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getInt(5),
                        rs.getBoolean(6)
                );
            }
        } catch (Exception e) {

        }
        return null;

    }

    public List<Address> getAllAddress(String gmail) {
        List<Address> list = new ArrayList<>();
        String query = "select * from Address where gmail = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, gmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                Address address = new Address(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                list.add(address);
            }
            return list;
        } catch (Exception ex) {
        }
        return null;
    }

    public void changePassword(String gmail, String newPassword) {
        String query = "UPDATE Account Set password = ? where gmail = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setString(2, gmail);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateAddress(String phone, String city, String district, String ward, String address, String ID) {
        String query = "UPDATE Address Set phone = ?, city=?, district=?,ward=?, address = ? where addID = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, phone);
            ps.setString(2, city);
            ps.setString(3, district);
            ps.setString(4, ward);
            ps.setString(5, address);
            ps.setString(6, ID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteAddress(String ID) {
        String query = "delete Address where addID= ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, ID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateAccount(String name, String gender, String gmail) {

        String query = "UPDATE Account Set name=?, gender = ? where gmail=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, gmail);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Address getOldAddress(String gmail,String nha, String tinh, String huyen, String xa) {
        List<Address> list = new ArrayList<>();
        String query = "select * from Address where gmail = ? and address=? and city = ? and district = ? and ward =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, gmail);
            ps.setString(2, nha);
            ps.setString(3, tinh);
            ps.setString(4, huyen);
            ps.setString(5, xa);
            rs = ps.executeQuery();
            while (rs.next()) {
                Address address = new Address(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                return address;
            }
        } catch (Exception ex) {
        }
        return null;
    }
    
    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                Account acc = new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getInt(5),
                        rs.getBoolean(6));
                list.add(acc);
            }

        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Account> searchAccByTXT(String txt) {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account\n"
                + "where gmail like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getInt(5),
                        rs.getBoolean(6))
                );
            }
            return list;
        } catch (Exception e) {

        }
        return null;

    }

    public void AddAccount(String gmail, String name, String gender, String role) {
        String query = "insert into Account values(?,'123456789a',?,?,?,'true')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, gmail);
            ps.setString(2, name);
            ps.setString(3, gender);
            ps.setString(4, role);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account getAccountByGmail(String gmail) {
        Account acc = new Account();
        String query = "select * from Account\n"
                + "where gmail = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, gmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc = new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getInt(5),
                        rs.getBoolean(6));

            }
            return acc;
        } catch (Exception e) {

        }
        return null;
    }
}
