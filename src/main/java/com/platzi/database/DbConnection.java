package com.platzi.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {

    private static DbConnection instance = null;
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

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static DbConnection getInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



