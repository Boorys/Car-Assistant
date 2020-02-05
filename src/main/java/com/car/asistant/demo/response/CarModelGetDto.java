package com.car.asistant.demo.response;

public class CarModelGetDto {

    private String carModel;
    private String brand;


    public CarModelGetDto(String carModel,String brand) {
        this.carModel = carModel;
        this.brand = brand;
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
