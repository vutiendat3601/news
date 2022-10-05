package com.dv.util;

import static com.dv.constant.DatabaseProperties.DRIVER;
import static com.dv.constant.DatabaseProperties.PASSWORD;
import static com.dv.constant.DatabaseProperties.URL;
import static com.dv.constant.DatabaseProperties.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static Connection connection;

    private DBUtil() {
    }

    private static void newConnectionInstance() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class.forName(" + DRIVER + ") -> NOT FOUND");
        }
        System.out.println("Connected to " + URL);
    }

    public static Connection getConnection() {
        if (connection == null) {
            newConnectionInstance();
        }
        return connection;
    }
}
