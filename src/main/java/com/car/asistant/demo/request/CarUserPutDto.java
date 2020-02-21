package com.car.asistant.demo.request;

import javax.validation.constraints.Min;

public class CarUserPutDto {

    @Min(value = 0, message = "Car milage must be positive")
    private int carMilages;
    @Min(value = 0, message = "Number of kilometers per month  must be positive")
    private int numberOfKilomentersPerMonth;
    @Min(value = 0, message = "Kilometers since the last change braek pads value must be positive")
    private int kilometersSinceTheLastChangeBraekPads;
    @Min(value = 0, message = "Kilometers since the last change oil must be positive")
    private int kilometersSinceTheLastChangeOil;
    @Min(value = 0, message = "Kilometers since the last change timing gear must be positive")
    private int kilometersSinceTheLastChangeTimingGear;

    public int getCarMilages() {
        return carMilages;
    }

    public void setCarMilages(int carMilages) {
        this.carMilages = carMilages;
    }

    public int getNumberOfKilomentersPerMonth() {
        return numberOfKilomentersPerMonth;
    }

    public void setNumberOfKilomentersPerMonth(int numberOfKilomentersPerMonth) {
        this.numberOfKilomentersPerMonth = numberOfKilomentersPerMonth;
    }

    public int getKilometersSinceTheLastChangeBraekPads() {
        return kilometersSinceTheLastChangeBraekPads;
    }

    public void setKilometersSinceTheLastChangeBraekPads(int kilometersSinceTheLastChangeBraekPads) {
        this.kilometersSinceTheLastChangeBraekPads = kilometersSinceTheLastChangeBraekPads;
    }

    public int getKilometersSinceTheLastChangeOil() {
        return kilometersSinceTheLastChangeOil;
    }

    public void setKilometersSinceTheLastChangeOil(int kilometersSinceTheLastChangeOil) {
        this.kilometersSinceTheLastChangeOil = kilometersSinceTheLastChangeOil;
    }

    public int getKilometersSinceTheLastChangeTimingGear() {
        return kilometersSinceTheLastChangeTimingGear;
    }

    public void setKilometersSinceTheLastChangeTimingGear(int kilometersSinceTheLastChangeTimingGear) {
        this.kilometersSinceTheLastChangeTimingGear = kilometersSinceTheLastChangeTimingGear;
    }
}
