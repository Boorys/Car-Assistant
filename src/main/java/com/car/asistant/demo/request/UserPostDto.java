package com.car.asistant.demo.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserPostDto {

    @Size(min = 3, max = 15,message ="First name must contain between 3 and 15 characters!")
    private String firstName;

    @Size(min = 3, max = 15,message ="Last name must contain between 3 and 15 characters!" )
    private String lastName;
    @Email(message ="Not valid email format!")
    private String email;

    @Size(min = 6, max = 15,message ="Password must contain between 6 and 15 characters!" )
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
