/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_mob1024.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class DBConnect {

    public static String HOSTNAME = "192.168.1.25";
    public static String PORT = "1433";
    public static String DBNAME = "Lab6Java_MOB1024";
    public static String USERNAME = "lab6_user";
    public static String PASSWORD = "123";

    public static String URL = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT 
            + ";databaseName=" + DBNAME + ";encrypt=true;trustServerCertificate=true";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Không tìm thấy SQL Server JDBC Driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}