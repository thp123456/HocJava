/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.HoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HoaDonDAO {
    public static double getProductPriceByName(String productName)
    {  
        double price = 0;
        try {
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            String sql = "SELECT PRICE FROM PRODUCT WHERE NAME = ?";
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sql);
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                price = resultSet.getDouble("PRICE");
        }
        provider.close();   
        } catch (Exception e) {
        }
        return price;
    }
    public static String getProductIDByName(String productName)
    {  
        String price = null;
        try {
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            String sql = "SELECT IDPRODUCT FROM PRODUCT WHERE NAME = ?";
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sql);
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                price = resultSet.getString(1);
        }
        provider.close();   
        } catch (Exception e) {
        }
        return price;
    }
    public static float tinhTongTien(DefaultTableModel model) 
    {
        float tongTien = (float) 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            double thanhTien = Double.parseDouble(model.getValueAt(i, 3).toString());
            tongTien += thanhTien;
        }

        return tongTien;
    }
    
    public static boolean InsertHoaDon(String DISCOUNT, String TOTALPRICE,String BILLDATE,String IDEMP,String IDCUS ) {
            String sql = String.format( "INSERT INTO BILL(IDBILL,DISCOUNT,TOTALPRICE,BILLDATE,IDEMP,IDCUS) VALUES (NEXT VALUE FOR BILLSEQU, %s, %s, '%s', '%s','%s');", DISCOUNT,  TOTALPRICE, BILLDATE, IDEMP, IDCUS);
            System.out.println(sql);
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            int rowsAffected = provider.executeUpdate(sql);
            provider.close();
            if(rowsAffected>0)
                return true;
            return false;
    }
    public static boolean InsertChiTietHoaDon(String idBill,String idProduct, String count,String discount,String total){
            String sql = String.format( "INSERT INTO BILLDETAILS(IDBILL,IDPRODUCT,COUNT,DISCOUNT,TOTAL) VALUES (%s,%s,%s,%s,%s);", idBill,idProduct,count,discount,total);
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            int rowsAffected = provider.executeUpdate(sql);
            provider.close();
            if(rowsAffected>0)
                return true;
            return false;
    }
    public static String LayMaHoaDon(){  
       String maHoaDon = null;
       String sql = "SELECT CURRENT_VALUE FROM sys.sequences WHERE name = 'BILLSEQU'";
       ResultSet rs = null;
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
       rs = provider.execteQuery(sql);
        try {
            rs.next();
            maHoaDon = rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        provider.close();
       return maHoaDon;
   }
    public static List<String> loadProductNames(int categoryID) {
        List<String> productNames = new ArrayList<>();
        
        try {
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            String sql = "SELECT NAME FROM PRODUCT WHERE IDCATEGORY = ?";
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryID);
            ResultSet rs  = preparedStatement.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("NAME");
                productNames.add(productName);
            }
            provider.close();
        } catch (Exception e) {
        }
        return productNames;
    }
    public static ArrayList<HoaDon> layDanhSachHoaDonTheoKhoangThoiGian(Date ngayTruoc, Date ngaySau) {
        ArrayList<HoaDon> dsHD = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String sql = "SELECT * FROM BILL WHERE BILLDATE BETWEEN ? AND ?";
        try 
        {
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            PreparedStatement preparedStatement = provider.connection.prepareStatement(sql);
            preparedStatement.setString(1, sdf.format(ngayTruoc));
            preparedStatement.setString(2, sdf.format(ngaySau));
            ResultSet rs = preparedStatement.executeQuery();
            
           
               
               while(rs.next()){
                HoaDon spr = new HoaDon();
                spr.setMaHoaDon(rs.getString(1));
                spr.setTongTien(rs.getFloat(3));
                spr.setNgayLap(rs.getString(4));
                spr.setMaKhachHang(rs.getString(6));
                dsHD.add(spr);
            }
               provider.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHD;
    }

  public static ArrayList<HoaDon> layDanhsacHoaDon(){
        ArrayList<HoaDon> dsHD = new ArrayList<>();
        try {
            String sql = "select * from BILL";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            while(rs.next()){
                HoaDon spr = new HoaDon();
                spr.setMaHoaDon(rs.getString(1));
                spr.setTongTien(rs.getFloat(3));
                spr.setNgayLap(rs.getString(4));
                spr.setMaKhachHang(rs.getString(6));
                dsHD.add(spr);
            }
            provider.close();
        } catch (SQLException e) {
        }
        return dsHD;
    }
public static Map<Integer, List<String>> layDanhsacHoaDonPhoBienTuMa(String maSanPham){
     Map<Integer, List<String>> billProductMap = new HashMap<>();
        ArrayList<HoaDon> dsHD = new ArrayList<>();
        try {
           String sql = "SELECT bd.IDBILL, p.NAME AS ProductName " +
                         "FROM BILLDETAILS bd " +
                         "JOIN PRODUCT p ON bd.IDPRODUCT = p.IDPRODUCT " +
                         "WHERE bd.IDBILL IN (SELECT IDBILL FROM BILLDETAILS WHERE IDPRODUCT = "+maSanPham+")";
           SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.execteQuery(sql);
            while(rs.next()){
                int idBill = rs.getInt("IDBILL");
                String productName = rs.getString("ProductName");
                billProductMap.computeIfAbsent(idBill, k -> new ArrayList<>()).add(productName);
            }
            provider.close();
        } catch (SQLException e) {
        }
        
        return billProductMap;
}
}
