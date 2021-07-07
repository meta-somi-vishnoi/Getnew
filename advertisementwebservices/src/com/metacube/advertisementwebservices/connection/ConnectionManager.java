package com.metacube.advertisementwebservices.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String databaseName = "advertisements";
    private static final String userName = "root";
    private static final String password = "user123";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String host = "jdbc:mysql://localhost:3306/";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver: " + cnfe);
        }
        return connection;
    }
}
