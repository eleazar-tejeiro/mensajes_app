package com.platzi.mensajes_app;

import java.sql.Connection;

public class Inicio {
    public static void main(String[] args) {

        Conexion conexion = new Conexion();
        try (Connection cnx = conexion.get_connection()) {
            System.out.println("Hello world!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}