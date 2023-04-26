package com.platzi.mensajes_app.service;

import com.platzi.mensajes_app.dao.MessageDAO;
import com.platzi.mensajes_app.model.Message;
import com.platzi.mensajes_app.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MessageService {
    static String messageTextMessage = "Escribe el mensaje, máx 280 caracteres";
    static String messageIdToBeDeletedMessage = "Indica el id del mensaje a borrar";
    public static void createMessage(User usuario, Scanner sc){
        System.out.println(messageTextMessage);
        String messageText = sc.next();
        Message message = new Message(messageText, usuario.getUserId());
        MessageDAO.createMessageDB(message);
    }
    public static void getAllMessages() {
        try {
            ResultSet rs = MessageDAO.readMessageDB();
            while (rs.next()) {
                System.out.print("\n[ID: " + rs.getString("id_mensaje") + " | ");
                System.out.print("Mensaje: -" + rs.getString("mensaje") + " | ");
                System.out.print("Autor: -" + rs.getString("nombre_completo") + " | ");
                System.out.print("Fecha: " + rs.getString("fecha") + " ] ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteMessage(Scanner sc) {
        System.out.println(messageIdToBeDeletedMessage);
        int messageId = sc.nextInt();
        MessageDAO.deleteMessageDB(messageId);
    }

    public static void editMessage() {

    }
}
