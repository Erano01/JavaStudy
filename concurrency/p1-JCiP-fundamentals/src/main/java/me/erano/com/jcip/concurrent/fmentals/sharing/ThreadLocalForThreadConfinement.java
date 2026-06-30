package me.erano.com.jcip.concurrent.fmentals.sharing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadLocalForThreadConfinement {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // Listing 3.10. Using ThreadLocal to Ensure thread Confinement.
    private static ThreadLocal<Connection> connectionHolder
            = new ThreadLocal<Connection>() {
        public Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public static Connection getConnection() {
        return connectionHolder.get();
    }
}
