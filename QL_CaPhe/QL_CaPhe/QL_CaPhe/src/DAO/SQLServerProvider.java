/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tranc
 */

public class SQLServerProvider {
    public static Connection connection;
    private final  String strServer = "MSI\\MSI";
    private final String strDatabase = "QLBANHANG";
    public static String username;
    public void open()
    {    
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
              String connectionUrl = "jdbc:sqlserver://"+strServer
                    +":1433;databaseName="+strDatabase
                    +";user =sa;password=123;trustServerCertificate=true;";
              connection = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    public boolean checkConnection(String userName,String passW){
        try {
            username = userName;
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
              String connectionUrl = "jdbc:sqlserver://"+strServer
                    +":1433;databaseName="+strDatabase
                    +";user ="+userName+";password="+passW+";trustServerCertificate=true;";
              connection = DriverManager.getConnection(connectionUrl);
              return true;
        } catch (ClassNotFoundException | SQLException e) {
                        System.out.println("Rỗng");

            return false;
        }
    }
    public void close(){
        try {
            this.connection.close();
        } catch (SQLException e) {
        }
    }
    public ResultSet execteQuery(String sql){
        ResultSet rs = null;
        try {
            Statement sm = connection.createStatement();
            rs = sm.executeQuery(sql);
        } catch (SQLException e) {
        }
        return rs;
        
    }
    public int executeUpdate(String sql){
        int n = -1;
        try {
            Statement sm = connection.createStatement();
            n = sm.executeUpdate(sql);
        } catch (SQLException e) {
        }
        return n;
    }
}
