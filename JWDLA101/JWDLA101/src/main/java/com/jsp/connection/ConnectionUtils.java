package com.jsp.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        // Here I using Oracle Database.
        // (You can change to use another database.)

        //return MySQLConnUtils.getMySQLConnection();
        return SQLServerConnUtils.getSQLServerConnection();
    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        Connection conn;
        try {
            conn = ConnectionUtils.getConnection();
            if (conn == null) {
                System.out.println("Error");
            } else {
                System.out.println("Success");
                System.out.println(conn);
                conn.close();
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
