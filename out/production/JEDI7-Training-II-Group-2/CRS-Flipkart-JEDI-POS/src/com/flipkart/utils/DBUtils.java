package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    public static Connection con = null;

    public static Connection getConnection() {
        if (con != null) return con;
        else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/crs", "AK18", "r8Qx#$PZ6oxn4GyoT8");
            } catch (Exception e) {
                System.out.println(e);
            }
            return con;
        }
    }
}
