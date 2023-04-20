package com.platzi.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection implements AutoCloseable {

    private static final DbConnection instance  = new DbConnection();
    private Connection connection;

    private DbConnection() {
        Dotenv dotenv = Dotenv.configure()
                .directory(System.getProperty("user.dir"))
                .load();

        try {
            connection = DriverManager.getConnection("jdbc:mysql://"
                            + dotenv.get("DATABASE_HOST") +
                            ":" + dotenv.get("DATABASE_PORT") +
                            "/" + dotenv.get("DATABASE_NAME") + "",
                    dotenv.get("DATABASE_USER"),
                    dotenv.get("DATABASE_PASSWORD"));
            if (connection != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static DbConnection getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}


