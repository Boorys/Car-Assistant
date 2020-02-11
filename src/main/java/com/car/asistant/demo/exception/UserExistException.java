package com.car.asistant.demo.exception;

public class UserExistException extends RuntimeException {


    private final String email;

    public UserExistException(String email) {
        super("Person exist with emial: " + email);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}


