/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass_mob1024.Database;

/**
 *
 * @author PC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String HOSTNAME = "s103-d186.interdata.vn";
    private static String PORT = "1433";
    private static String DBNAME = "fps";
    private static String USER = "fps_thientq";
    private static String PASSWORD = "T8^Y2W7n~h9mJu";

    public static void setHOSTNAME(String HOSTNAME) {
        DBConnection.HOSTNAME = HOSTNAME;
    }

    public static void setPORT(String PORT) {
        DBConnection.PORT = PORT;
    }

    public static void setDBNAME(String DBNAME) {
        DBConnection.DBNAME = DBNAME;
    }

    public static void setUSER(String USER) {
        DBConnection.USER = USER;
    }

    public static void setPASSWORD(String PASSWORD) {
        DBConnection.PASSWORD = PASSWORD;
    }
    
    public static Connection getConnection() {
        
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(
            "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";databaseName=" + DBNAME + 
                    ";encrypt=true;trustServerCertificate=true", USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại!");
        }
        return conn;
    }

}
