package com.car.asistant.demo.response;



public class CarUserDto {


    private long id;
    private String carUserId;
    private String userId;
    private int carMilages;
    private int numberOfKilomentersPerMonth;
    private long carModelId;
    private int kilometersSinceTheLastChangeBraekPads;
    private  int kilometersSinceTheLastChangeOil;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarUserId() {
        return carUserId;
    }

    public void setCarUserId(String carUserId) {
        this.carUserId = carUserId;
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

    public long getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(long carModelId) {
        this.carModelId = carModelId;
    }



}

