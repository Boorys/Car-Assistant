package com.car.asistant.demo.request;


public class CarUserRequestModel {

    private String userId;
    private int carMilages;
    private int numberOfKilomentersPerMonth;
    private int kilometersSinceTheLastChangeBraekPads;
    private int kilometersSinceTheLastChangeOil;
    private int kilometersSinceTheLastChangeTimingGear;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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


}