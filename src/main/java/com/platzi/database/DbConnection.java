package com.platzi.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public Connection getConnection() {

        Dotenv dotenv = Dotenv.configure()
                .directory(System.getProperty("user.dir"))
                .load();

        Connection connection = null;
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
        return connection;
    }
}
