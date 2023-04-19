package com.platzi.mensajes_app.model;

public class User {
    //Attributes
    private int userId;
    private String email;
    private String password;
    private String fullName;

    public User() {
    }

    /**
     * Constructor for delete an User
     * @param userId
    * */
    public User(int userId) {
        this.userId = userId;
    }

    /**
     * Constructor to login an User
     * @param email
     * @param password
     * */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor to bring information of an User
     * @param email
     * @param password
     * @param fullName
     * */
    public User(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    /**
     * Constructor to create an User
     * @param userId
     * @param email
     * @param password
     * @param fullName
     * */
    public User(int userId, String email, String password, String fullName) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
