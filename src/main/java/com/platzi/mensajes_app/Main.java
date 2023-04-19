package com.platzi.mensajes_app;

import com.platzi.database.DbConnection;
import com.platzi.mensajes_app.service.MessageService;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    static String mainMenuMessage = ("=================== \n"
            + "\n Mini red social \n"
            + "1. Crear mensaje \n"
            + "2. Listar mensaje \n"
            + "3. Editar mensaje \n"
            + "4. Eliminar mensaje \n"
            + "5. Salir \n");

    public static void mainMenu(Scanner sc) {

        int option = 0;

        //First Menu
        do {
            System.out.println(mainMenuMessage);
            //Read user input
            option = sc.nextInt();

            switch (option) {
                case 1:
                    MessageService.createMessage();
                    break;
                case 2:
                    MessageService.getAllMessages();
                    break;
                case 3:
                    MessageService.editMessage();
                    break;
                case 4:
                    MessageService.deleteMessage();
                    break;
                default:
                    break;
            }
        } while (option != 5);
    }

    public static void main(String[] args) {
        //create an instance of Scanner class to read user input
        Scanner sc = new Scanner(System.in);
        mainMenu(sc);
        sc.close();
    }
}