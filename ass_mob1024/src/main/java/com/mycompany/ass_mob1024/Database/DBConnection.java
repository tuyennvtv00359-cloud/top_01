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

    private static final String URL =
            "jdbc:sqlserver://s103-d186.interdata.vn:1433;databaseName=fps;encrypt=true;trustServerCertificate=true";

    private static final String USER = "fps_thientq";
    private static final String PASSWORD = "T8^Y2W7n~h9mJu";

    public static Connection getConnection() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {

            System.out.println("Kết nối thất bại!");
            e.printStackTrace(); 
        }
        return conn;
    }

}
