package com.platzi.mensajes_app.dao;
import com.platzi.database.DbConnection;
import com.platzi.mensajes_app.model.Message;

import java.sql.Connection;

public class MessageDAO {
    public static void createMessageDB(Message message) {
        DbConnection dbConnection = DbConnection.getInstance();
        Connection connection = dbConnection.getConnection();

    }

    public static void readMessageDB () {

    }

    public static void deleteMessageDB (int id_message) {

    }

    public static void updateMessageDB (Message message) {

    }
}
