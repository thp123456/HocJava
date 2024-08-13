/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.NhanVien;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tranc
 */
public class NhanVienDAO {
    public static ArrayList<NhanVien> layDanhsachNhanVien(){
        ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
        try {
            String sql = "select * from EMPLOYEES";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            while(rs.next()){
                NhanVien employee = new NhanVien();
                employee.setIdEmp(rs.getString(1));
                employee.setName(rs.getString(2));
                employee.setEmail(rs.getString(3));
                employee.setPosition(rs.getString(4));
                employee.setAddress(rs.getString(5));
                employee.setBirthYear(rs.getInt(6));
                employee.setPhone(rs.getString(7));
               
                dsNhanVien.add(employee);
            }
            provider.close();
        } catch (SQLException e) {
        }
        return dsNhanVien;
    }
    public static boolean kiemTraUserName(String userName){
        String sql = "select count(*) from ACCOUNT where USERNAME = '"+userName.trim()+"'";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        ResultSet rs = provider.execteQuery(sql);
        int chk = -1;
        try {
            rs.next();
            chk = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        provider.close();
        if(chk==0)
            return true;
        return false;
    }
    public static boolean kiemTraEmail(String email){
        String sql = "select count(*) from ACCOUNT where USERNAME = '"+email+"'";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        ResultSet rs = provider.execteQuery(sql);
        int chk = -1;
        try {
            rs.next();
            chk = rs.getInt(1);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        provider.close();
        if(chk==0)
            return true;
        return false;
    }
    public static boolean CreateManager(String userName,String passWord,String name,String email,String position,String address,String birthYear,String phone,String ImagePath){
        String sql = "Exec CreateUserManager '"+userName+"', '"+passWord+"', N'"+name+"', '"+email+"', '"+position+"', N'"+address+"', '"+birthYear+"','"+phone+"','"+ImagePath+"'";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int rs = -1;
        rs = provider.executeUpdate(sql);
        provider.close();
        if(rs!=0 && rs !=-1)return true;
        return false;
    }
    public static boolean CreateStaff(String userName,String passWord,String name,String email,String position,String address,String birthYear,String phone,String ImagePath){
        String sql = "Exec CreateUserStaff '"+userName+"', '"+passWord+"', N'"+name+"', '"+email+"', '"+position+"', N'"+address+"', '"+birthYear+"','"+phone+"','"+ImagePath+"'";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int rs = -1;
        rs = provider.executeUpdate(sql);
        provider.close();
        if(rs!=0 && rs !=-1)return true;
        return false;
    }
   public static void deleteEmployee(String id){
       String sql = " exec deleteNhanVien '"+id+"'";
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
       provider.executeUpdate(sql);
       provider.close();
   }
   public static void updateEmployee(String idEmp, String name, String email, String position, String address, String birthYear, String phone) {
    String sql = "UPDATE EMPLOYEES " +
                 "SET NAME = ?, " +
                 "    EMAIL = ?, " +
                 "    POSITION = ?, " +
                 "    ADDRESS = ?, " +
                 "    BIRTHYEAR = ?, " +
                 "    PHONE = ?, " +
                 // Thêm cột ImagePath vào câu lệnh SQL UPDATE
                 "WHERE IDEMP = ?";
    PreparedStatement preparedStatement = null;
    SQLServerProvider provider = new SQLServerProvider();
    provider.open();
    try {
        preparedStatement = SQLServerProvider.connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, position);
        preparedStatement.setString(4, address);
        preparedStatement.setInt(5, Integer.parseInt(birthYear));
        preparedStatement.setString(6, phone);
        // Đặt giá trị của ImagePath
        preparedStatement.setString(8, idEmp);
        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            provider.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

   public static ArrayList<NhanVien> findEmployee(String search){
       String sql = "exec findEmployee ?";
        ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
       PreparedStatement preparedStatement;
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
        try {
            preparedStatement = provider.connection.prepareCall(sql);
            preparedStatement.setString(1, search);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                NhanVien employee = new NhanVien();
                employee.setIdEmp(rs.getString(1));
                employee.setName(rs.getString(2));
                employee.setEmail(rs.getString(3));
                employee.setPosition(rs.getString(4));
                employee.setAddress(rs.getString(5));
                employee.setBirthYear(rs.getInt(6));
                employee.setPhone(rs.getString(7));
               
                dsNhanVien.add(employee);
            }
            provider.close();
            preparedStatement.close();
            return dsNhanVien;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNhanVien;
   }
   public static String TimMaNhanVienTuUserName(){
       String maNhanVien= null;
       String sql = "select IDEMP from ACCOUNT where USERNAME = '"+SQLServerProvider.username+"'";
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
       ResultSet rs ;
       rs = provider.execteQuery(sql);
        try {
            rs.next();
            maNhanVien = rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        provider.close();
       return maNhanVien;
   }
   public static  NhanVien TimNhanVienTuMaNhanVien(){
       NhanVien nv = new   NhanVien();
       String sql = "select * from EMPLOYEES where IDEMP = '"+TimMaNhanVienTuUserName()+"'";
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
       ResultSet rs = null;
       rs = provider.execteQuery(sql);
        try {
            rs.next();
            nv.setIdEmp(rs.getString(1));
            nv.setName(rs.getString(2));
            nv.setEmail(rs.getString(3));
            nv.setPosition(rs.getString(4));
            nv.setAddress(rs.getString(5));
            nv.setBirthYear(Integer.parseInt(rs.getString(6)));
            nv.setPhone(rs.getString(7));
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        provider.close();
       return nv;
   }
   public static NhanVien getInformationEmployeebyID(String id) {
        String sql = "select * from EMPLOYEES where IDEMP = ?";
        PreparedStatement preparedStatement;
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        NhanVien employee = new NhanVien();
        try {
            preparedStatement = provider.connection.prepareCall(sql);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                employee.setIdEmp(rs.getString(1));
                employee.setName(rs.getString(2));
                employee.setEmail(rs.getString(3));
                employee.setPosition(rs.getString(4));
                employee.setAddress(rs.getString(5));
                employee.setBirthYear(rs.getInt(6));
                employee.setPhone(rs.getString(7));
                
            }
            provider.close();
            preparedStatement.close();
            return employee;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }
}
