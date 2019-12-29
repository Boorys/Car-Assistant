package com.car.asistant.demo.response;

import java.util.List;

public class UserRest {

    private String firstName;
    private String lastName;
    private List<CarUserRest> carsUser;

    public List<CarUserRest> getCarsUser() {
        return carsUser;
    }

    public void setCarsUser(List<CarUserRest> carsUser) {
        this.carsUser = carsUser;
    }

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
}
