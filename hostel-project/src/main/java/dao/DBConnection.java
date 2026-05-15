package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection con;

    private static final String URL      = "jdbc:mysql://localhost:3306/hostel_db"
                                         + "?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Vigneshs@7";

    private DBConnection() {
    }

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                System.out.println("DBConnection: New connection established.");
            }
        } catch (ClassNotFoundException e) {

            System.err.println("ERROR: MySQL JDBC Driver not found. "
                             + "Add mysql-connector-j to pom.xml.");
            e.printStackTrace();
        } catch (SQLException e) {

            System.err.println("ERROR: Cannot connect to database. "
                             + "Check URL, username, and password.");
            e.printStackTrace();
        }
        return con;
    }
}
