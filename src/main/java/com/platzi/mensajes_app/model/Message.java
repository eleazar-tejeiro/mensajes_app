package com.platzi.mensajes_app.model;

public class Message {
    //attributes
    private int messageId;
    private String message;
    private String date;
    private String fullName;
    //foreign attributes
    private int userId;

    //constructors
    public Message(){
    }

    /**
     * Constructor to delete a message by Id
     * @param messageId
     * */
    public Message(int messageId, int userId) {
        this.messageId = messageId;
        this.userId = userId;
    }

    /**
     * Constructor to create a message
     * @param message
     * @param userId
     * */
    public Message(String message, int userId) {
        this.message = message;
        this.userId = userId;
    }

    /**
     * Constructor to list all messages
     * @param messageId
     * @param message
     * @param date
     * @param fullName
     * */
    public Message(int messageId, String message, String date, String fullName) {
        this.messageId = messageId;
        this.message = message;
        this.date = date;
        this.fullName = fullName;
    }

    //getters and setters
    public int getmessageId() {
        return messageId;
    }

    public void setmessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }
}
