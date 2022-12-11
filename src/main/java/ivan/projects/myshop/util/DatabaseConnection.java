package ivan.projects.myshop.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/demo";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "postgres";

    private static final Connection connection;

    //Инициализация jdbc (делать синглтон?)
    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            DatabaseMetaData dma = connection.getMetaData();
            System.out.println("Connected to " + dma.getURL());
            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            System.err.println("Can't connect!");
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
