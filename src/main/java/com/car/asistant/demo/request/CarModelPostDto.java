package com.car.asistant.demo.request;

public class CarModelPostDto {

    private int oil;
    private int timingGear;
    private int brakePads;
    private String model;
    private String carBrand;

    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public int getTimingGear() {
        return timingGear;
    }

    public void setTimingGear(int timingGear) {
        this.timingGear = timingGear;
    }

    public int getBrakePads() {
        return brakePads;
    }

    public void setBrakePads(int brakePads) {
        this.brakePads = brakePads;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
}
