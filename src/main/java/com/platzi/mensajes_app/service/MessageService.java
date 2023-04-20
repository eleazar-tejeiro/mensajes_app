package com.platzi.mensajes_app.service;

import com.platzi.mensajes_app.dao.MessageDAO;
import com.platzi.mensajes_app.model.Message;
import com.platzi.mensajes_app.model.User;

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

    }

    public static void deleteMessage() {

    }

    public static void editMessage() {

    }
}
