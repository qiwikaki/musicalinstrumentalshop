package ivan.projects.myshop;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShopApplication {

   private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
   public static final String USERNAME = "qiwikaki";
   public static final String PASSWORD = "phantom1!56AS";


    public static void main(String[] args) {

        Connection connection;

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Connect to the DB access!");
            }
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Disconnect to the DB!");
            }
        } catch (SQLException e) {
            System.err.println("Failed to load driver class");
        }
    }
}
