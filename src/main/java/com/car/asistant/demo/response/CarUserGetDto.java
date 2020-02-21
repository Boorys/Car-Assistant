package com.car.asistant.demo.response;

public class CarUserGetDto {

    private int carMilages;
    private int numberOfKilomentersPerMonth;
    private int kilometersSinceTheLastChangeBraekPads;
    private int kilometersSinceTheLastChangeOil;
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
