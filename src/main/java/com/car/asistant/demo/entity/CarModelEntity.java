package com.car.asistant.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class CarModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 45)
    private String carModelId;

    @Column(nullable = false, length = 45)
    private int timingGear;

    @Column(nullable = false, length = 45)
    private String carBrand;

    @Column(nullable = false, length = 45)
    private String model;

    @Column(nullable = false, length = 45)
    private int brakePads;

    @Column(nullable = false, length = 45)
    private int oil;

    @OneToMany(mappedBy = "carModel", cascade = CascadeType.ALL)
    private List<CarUserEntity> carsUser;


    public List<CarUserEntity> getCarsUser() {
        return carsUser;
    }

    public void setCarsUser(List<CarUserEntity> carsUser) {
        this.carsUser = carsUser;
    }

    public String getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(String carModelId) {
        this.carModelId = carModelId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTimingGear() {
        return timingGear;
    }

    public void setTimingGear(int timingGear) {
        this.timingGear = timingGear;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBrakePads() {
        return brakePads;
    }

    public void setBrakePads(int brakePads) {
        this.brakePads = brakePads;
    }

    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }
}
