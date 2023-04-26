package com.platzi.mensajes_app.dao;

import com.platzi.database.DbConnection;
import com.platzi.mensajes_app.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static ResultSet readMessageDB() throws SQLException {
        DbConnection dbConnection = DbConnection.getInstance();
        Connection connection = dbConnection.getConnection();
        PreparedStatement ps = null;
        try {
            String query = "SELECT id_mensaje, mensaje, nombre_completo, fecha FROM mensajes INNER JOIN usuarios on mensajes.id_usuario = usuarios.id_usuario";
            ps = connection.prepareStatement(query);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteMessageDB(int id_message) {
        DbConnection dbConnection = DbConnection.getInstance();
        Connection connection = dbConnection.getConnection();
        PreparedStatement ps;
        try {
            String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_message);
            int countRowsUpdated = ps.executeUpdate();
            if (countRowsUpdated != 0)
                System.out.println("Message with id "+id_message+" has been deleted.");
            else
                System.out.println("Message with id "+id_message+" was not found.");
        } catch (SQLException e) {
            System.out.println("It wasn't possible delete the message " + e.getMessage());
        }
    }

    public static void updateMessageDB(Message message) {
    }
}
