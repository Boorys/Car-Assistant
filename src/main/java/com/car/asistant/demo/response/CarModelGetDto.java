package com.car.asistant.demo.response;

public class CarModelGetDto {

    private String carModel;
    private String brand;
    private String carUserId;

    public CarModelGetDto(String carModel, String brand, String carUserId) {
        this.carModel = carModel;
        this.brand = brand;
        this.carUserId = carUserId;
    }

    public String getCarUserId() {
        return carUserId;
    }

    public void setCarUserId(String carUserId) {
        this.carUserId = carUserId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
