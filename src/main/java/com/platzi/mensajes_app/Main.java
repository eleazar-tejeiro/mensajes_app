package com.platzi.mensajes_app;

import com.platzi.database.DbConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        DbConnection conexion = new DbConnection();
        try (Connection cnx = conexion.getConnection()) {
            System.out.println("Hello world!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}