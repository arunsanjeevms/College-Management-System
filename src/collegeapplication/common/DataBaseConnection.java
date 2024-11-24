package collegeapplication.common;

import java.sql.*;

public class DataBaseConnection {
    
    static Connection con = null;
    static final String url = "jdbc:mysql://localhost:3306/college_management_system?useSSL=false&allowPublicKeyRetrieval=true";
    static final String uname = "root";
    static final String password = "arun";
    
    // Get connection method
    public static Connection getConnection() {
        if (con != null) {
            return con;
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, uname, password);
                return con;
            } catch (Exception exp) {
                exp.printStackTrace();
                return con;
            }
        }
    }

    // Method to check connection status
    public static boolean checkconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8.x driver
            con = DriverManager.getConnection(url, uname, password);
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

    // Close connection method
    public static void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
