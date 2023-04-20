package com.platzi.mensajes_app;

import com.platzi.database.DbConnection;
import com.platzi.mensajes_app.model.User;
import com.platzi.mensajes_app.service.MessageService;
import com.platzi.mensajes_app.service.UserService;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    static String mainMenuMessage = ("=================== \n"
            + "\n Mini Social Network Java \n"
            + "1. Sign up \n"
            + "2. Log in \n"
            + "3. Exit \n");

    public static void mainMenu(Scanner sc) {

        int option = 0;

        //First Menu
        do {
            System.out.println(mainMenuMessage);
            //Read user input
            option = sc.nextInt();

            switch (option) {
                case 1:
                    UserService.createUser(sc);
                    break;
                case 2:
                    User resultado = UserService.login(sc);
                    if (resultado.getUserId() > 0) {
                        SessionMenu.menuSesion(resultado, sc);
                    }
                    break;
                default:
                    break;
            }
        } while (option != 3);
    }

    public static void main(String[] args) {
        //create an instance of Scanner class to read user input
        Scanner sc = new Scanner(System.in);
        mainMenu(sc);
        sc.close();
    }
}