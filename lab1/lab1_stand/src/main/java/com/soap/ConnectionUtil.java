package com.soap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConnectionUtil {
    private static final String JDBC_URL =
            "jdbc:postgresql://localhost:5432/postgres";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "postgres";
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER,
                    JDBC_PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return connection;
    }
}