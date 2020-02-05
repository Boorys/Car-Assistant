package com.car.asistant.demo.response;

public class CarUserToInformationDto {


    private String email;
    private byte oil;
    private byte timingGear;
    private byte breakPads;
    private String firstName;
    private String carModel;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getOil() {
        return oil;
    }

    public void setOil(byte oil) {
        this.oil = oil;
    }

    public byte getTimingGear() {
        return timingGear;
    }

    public void setTimingGear(byte timingGear) {
        this.timingGear = timingGear;
    }

    public byte getBreakPads() {
        return breakPads;
    }

    public void setBreakPads(byte breakPads) {
        this.breakPads = breakPads;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}
