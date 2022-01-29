package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

    private static Connection connection = null;
    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                String driver="com.mysql.jdbc.Driver";
                String url="jdbc:mysql://localhost:3306/crs";
                String user="root";
                String password="root";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
