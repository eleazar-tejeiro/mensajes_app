package com.platzi.mensajes_app.dao;

import com.platzi.database.DbConnection;
import com.platzi.mensajes_app.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {
    public static void createMessageDB(Message message) {
        DbConnection dbConnection = DbConnection.getInstance();
        Connection connection = dbConnection.getConnection();
        PreparedStatement ps = null;
        try {
            String query = "insert into mensajes(id_usuario,mensaje,fecha) values (?,?,CURRENT_TIMESTAMP)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, message.getUserId());
            ps.setString(2, message.getMessage());
            ps.executeUpdate();
            System.out.println("Mensaje creado");
        } catch (SQLException e) {
            System.out.println("No se pudo crear el mensaje " + e.getMessage());
        }
    }

    public static void readMessageDB() {

    }

    public static void deleteMessageDB(int id_message) {

    }

    public static void updateMessageDB(Message message) {

    }
}
