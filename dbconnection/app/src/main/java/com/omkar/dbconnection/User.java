package com.omkar.dbconnection;

public class User {
    public String name, email, phone;

    public User() {
        // required for Firebase
    }

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}