package com.car.asistant.demo.exception;

public class UserNotEnabledException extends RuntimeException {


    private final String email;

    public UserNotEnabledException(String email) {
        super("Account is not activated: " + email);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}


