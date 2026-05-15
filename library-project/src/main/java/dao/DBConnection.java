package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection con;

    private static final String URL = "jdbc:mysql://localhost:3306/library_db"
            + "?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Vigneshs@7";

    private DBConnection() {}

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("[DBConnection] New DB connection created.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("[ERROR] MySQL Driver not found. Check pom.xml.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("[ERROR] Cannot connect to DB. Check URL/credentials.");
            e.printStackTrace();
        }
        return con;
    }
}