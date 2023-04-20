package com.platzi.mensajes_app;

import com.platzi.mensajes_app.model.User;
import com.platzi.mensajes_app.service.MessageService;
import com.platzi.mensajes_app.service.UserService;

import java.util.Scanner;

public class SessionMenu {
    public static void menuSesion(User usuario, Scanner sc) {
        int option = 0;
        String sessionMenuMessage = ("=================== \n"
                + "\n Social Network Java, Hello " + usuario.getFullName() + " \n"
                + "1. Write a messages \n"
                + "2. Read messages \n"
                + "3. Delete a message \n"
                + "4. Edit your profile \n"
                + "5. See users \n"
                + "6. Sign out \n");

        //menu when session starts
        do {
            System.out.println(sessionMenuMessage);
            //Read user input
            option = sc.nextInt();

            switch (option) {
                case 1:
                    MessageService.createMessage(usuario, sc);
                    break;
                case 2:
                    MessageService.getAllMessages();
                    break;
                case 3:
                    MessageService.deleteMessage();
                    break;
                case 4:
                    UserService.editUser(usuario, sc);
                    break;
                case 5:
                    UserService.listUsers();
                    break;
                default:
                    break;
            }
        } while (option != 6);
    }
}
