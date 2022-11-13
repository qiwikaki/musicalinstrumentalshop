package ivan.projects.myshop;

import java.sql.*;

public class ShopApplication {

   private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
   public static final String USERNAME = "qiwikaki";
   public static final String PASSWORD = "phantom1!56AS";


    public static void main(String[] args) {

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
//            statement.execute("INSERT INTO users (name, age, email) values('Пингвин', 5, 'kinder@');");
//            int res = statement.executeUpdate("UPDATE users SET name = 'Пингвин' WHERE idusers = 11;");
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
//            statement.addBatch("");
//            boolean status = statement.isClosed();
//            statement.getConnection();
//            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        Connection connection;
//
//        try {
//            Driver driver = new com.mysql.cj.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
//            if (!connection.isClosed()) {
//                System.out.println("Connect to the DB access!");
//            }
//            connection.close();
//            if (connection.isClosed()) {
//                System.out.println("Disconnect to the DB!");
//            }
//        } catch (SQLException e) {
//            System.err.println("Failed to load driver class");
//        }
    }
}
