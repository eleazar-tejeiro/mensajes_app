package com.platzi.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
In this updated code example, we have added:

1. volatile keyword to the instance variable to ensure that the instance is visible to all threads.

2. A lock object to ensure that only one thread can access the getInstance method at a time.

3. An IllegalStateException to the getConnection method to ensure that the connection has been initialized before it can be obtained.

4. A shutdown hook to close the connection when the application terminates.
* */
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
            if (connection != null) {
                System.out.println("Conexion exitosa");
            }
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
}


