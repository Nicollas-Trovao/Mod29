package src.Main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory() {

    }

    public static Connection getConnection() throws SQLException {
    if (connection == null){
        connection = iniConnetcion();
        return connection;
        
    } else if (connection.isClosed()){
        connection = iniConnetcion();
        return connection;

    } else {
        return connection;
    }
    }

    private static Connection iniConnetcion() {
    try {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sou100forte");
    } catch(SQLException e){
        throw new RuntimeException(e);
    }
    }
}
