/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.NhanVienDAO.TimMaNhanVienTuUserName;
import POJO.KhachHang;
import POJO.NhanVien;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tranc
 */
public class KhachHangDAO {
    
   public static  KhachHang TimKhachHangTuMaThe(String soThe){
       KhachHang nv = new   KhachHang();
       String sql = "select * from CUSTOMER where IDCUS = '"+soThe+"'";
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
       ResultSet rs = null;
       rs = provider.execteQuery(sql);
        try {
            rs.next();
            nv.setIdEmp(rs.getString(1));
            nv.setName(rs.getString(2));
            nv.setEmail(rs.getString(3));
            nv.setDiemThuong(Float.parseFloat(rs.getString(7)));
            nv.setAddress(rs.getString(4));
            nv.setBirthYear(Integer.parseInt(rs.getString(5)));
            nv.setPhone(rs.getString(6));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(NhanVienDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        provider.close();
       return nv;
   }
    public static ArrayList<String> layDanhsachMaKH(){
        ArrayList<String> dsSanPham = new ArrayList<>();
        try {
            String sql = "SELECT IDCUS FROM CUSTOMER;";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            while(rs.next()){
                dsSanPham.add(rs.getString(1));
            }
            provider.close();
        } catch (SQLException e) {
        }
        return dsSanPham;
    }
    public static ArrayList<KhachHang> layDanhsachNhanVien(){
        ArrayList<KhachHang> dsNhanVien = new ArrayList<>();
        try {
            String sql = "select * from CUSTOMER";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            while(rs.next()){
                KhachHang employee = new KhachHang();
                employee.setIdEmp(rs.getString(1));
                employee.setName(rs.getString(2));
                employee.setEmail(rs.getString(3));
                employee.setDiemThuong(Float.parseFloat(rs.getString(7)));
                employee.setAddress(rs.getString(4));
                employee.setBirthYear(rs.getInt(5));
                employee.setPhone(rs.getString(6));
                dsNhanVien.add(employee);
            }
            provider.close();
        } catch (SQLException e) {
        }
        return dsNhanVien;
    }
    public static String LayMaThanhVien(){  
       String maHoaDon = null;
       String sql = "SELECT CURRENT_VALUE FROM sys.sequences WHERE name = 'KHACHSEQU'";
       ResultSet rs = null;
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
       rs = provider.execteQuery(sql);
        try {
            rs.next();
            maHoaDon = rs.getString(1);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(HoaDonDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        provider.close();
       return maHoaDon;
   }
   public static boolean CreateKhachHang(String name,String email,String address,String namsinh,String phone,String diem){
       String sql = String.format("INSERT INTO CUSTOMER (IDCUS, NAME, EMAIL, ADDRESS, BIRTHYEAR, PHONE, DIEMTHUONG) " +
        "VALUES (NEXT VALUE FOR KHACHSEQU, N'%s', '%s', N'%s', %s, '%s', %s)", name, email, address, namsinh, phone, diem);

        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int rs = -1;
        rs = provider.executeUpdate(sql);
        provider.close();
        if(rs!=0 && rs !=-1)return true;
        return false;
    }
   public static void deleteKhachHang(String id){
       String sql = " delete CUSTOMER where IDCUS = '"+id+"'";
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
       provider.executeUpdate(sql);
       provider.close();
   }
   public static void updateKhachHang(String idEmp, String name, String email, String diem, String address, String birthYear, String phone){
       String sql = """
                    update CUSTOMER
                    set NAME = ?
                    ,EMAIL = ?
                    ,DIEMTHUONG = ?
                    ,ADDRESS =?
                    ,BIRTHYEAR = ?
                    ,PHONE = ?
                     where IDCUS = ?""";
       PreparedStatement preparedStatement;
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
        try {
            preparedStatement = SQLServerProvider.connection.prepareCall(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, diem);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, Integer.parseInt(birthYear));
            preparedStatement.setString(6, phone);
            preparedStatement.setString(7, idEmp);
            preparedStatement.executeUpdate();
            provider.close();
            preparedStatement.close();
        } catch (SQLException ex) {
           
        }
       provider.close();
   }
   public static boolean updateDiemThuong(String Id,String DiemThuong){
       String sql = "update CUSTOMER    set   DIEMTHUONG = "+DiemThuong+"  where IDCUS = '"+Id+"'";
       SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            int rs = provider.executeUpdate(sql);
            if(rs ==-1)
                return false;
            return true;
   }
   public static ArrayList<KhachHang> findKhachHang(String search){
       
       String sql = "SELECT *    FROM CUSTOMER" +
                        "    WHERE NAME LIKE '%"+search+" %'  " +
                        "    OR IDCUS LIKE '%"+search+"%' "+
                        "    OR PHONE LIKE   '%"+search+"%'";
       System.out.println(sql);
        ArrayList<KhachHang> dsNhanVien = new ArrayList<>();
        ResultSet rs;
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
        try {
            rs= provider.execteQuery(sql);
            while(rs.next()){
               KhachHang employee = new KhachHang();
                employee.setIdEmp(rs.getString(1));
                employee.setName(rs.getString(2));
                employee.setEmail(rs.getString(3));
                employee.setDiemThuong(Float.parseFloat(rs.getString(7)));
                employee.setAddress(rs.getString(4));
                employee.setBirthYear(rs.getInt(5));
                employee.setPhone(rs.getString(6));
                dsNhanVien.add(employee);
            }
            provider.close();
            return dsNhanVien;
        } catch (SQLException ex) {
            
        }
        return dsNhanVien;
   }
}
