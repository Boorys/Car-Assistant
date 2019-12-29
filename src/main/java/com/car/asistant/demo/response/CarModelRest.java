package com.car.asistant.demo.response;

public class CarModelRest {


    private String carModelId;
    private int timingGear;
    private String carBrand;
    private String model;
    private int brakePads;
    private int oil;

    public void setCarModelId(String carModelId) {
        this.carModelId = carModelId;
    }

    public void setTimingGear(int timingGear) {
        this.timingGear = timingGear;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrakePads(int brakePads) {
        this.brakePads = brakePads;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public String getCarModelId() {
        return carModelId;
    }

    public int getTimingGear() {
        return timingGear;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getModel() {
        return model;
    }

    public int getBrakePads() {
        return brakePads;
    }

    public int getOil() {
        return oil;
    }
}



