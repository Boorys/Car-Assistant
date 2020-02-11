package com.car.asistant.demo.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CarModelPostDto {

    @Min(value = 0, message = "Oil value must be positive")
    private int oil;
    @Min(value = 0, message = "Timing gear value must be positive")
    private int timingGear;
    @Min(value = 0, message = "Break pads value must be positive")
    private int brakePads;
    @Size( max = 20,message ="Model must short than 20 characters!")
    private String model;
    @Size( max = 20,message ="Brand must short than 20 characters!")
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
