package com.company.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler {

    private final String dbName = "se";

    private final String dbUser = "root";

    private final String infoTable = "information";

    private final String connectionString = "jdbc:mysql://127.0.0.1/" + dbName + "?user=" + dbUser + "&useSSL=false";

    private static DBHandler ourInstance = new DBHandler();

    public static DBHandler getInstance() {
        return ourInstance;
    }

    private Connection conn;

    private DBHandler() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(connectionString);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (conn == null) {
            System.out.println("Connection failed");
        } else {
            System.out.println("Connection success");
        }
    }

    public void insertIpAddress(String ipAddress) {
        String query = "INSERT INTO " + infoTable + "(ipAddress, timeStamp) VALUES(?,?)";
        long time = System.currentTimeMillis();


        java.sql.Timestamp timestamp = new java.sql.Timestamp(time);


        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ipAddress);
            ps.setTimestamp(2, timestamp);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
