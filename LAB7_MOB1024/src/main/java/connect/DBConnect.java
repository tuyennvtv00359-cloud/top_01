/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public class DBConnect {
    public static Connection getConnection() {
      
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Lab6;encrypt=false";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, "sa", "chu cuong");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

