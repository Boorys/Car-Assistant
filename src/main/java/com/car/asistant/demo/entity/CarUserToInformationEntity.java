package com.car.asistant.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CarUserToInformationEntity {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String email;
    @Column
    private byte oil;
    @Column
    private byte timingGear;
    @Column
    private byte breakPads;
    @Column
    private String firstName;
    @Column
    private String carModel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
