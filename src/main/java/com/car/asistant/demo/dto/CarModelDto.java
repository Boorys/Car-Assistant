package com.car.asistant.demo.dto;

public class CarModelDto {


    private long id;
    private String carModelId;
    private String carUserId;
    private int timingGear;
    private String carBrand;
    private String model;
    private int brakePads;
    private int oil;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(String carModelId) {
        this.carModelId = carModelId;
    }

    public String getCarUserId() {
        return carUserId;
    }

    public void setCarUserId(String carUserId) {
        this.carUserId = carUserId;
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
