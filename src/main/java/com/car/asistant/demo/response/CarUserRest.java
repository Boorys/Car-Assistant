package com.car.asistant.demo.response;

public class CarUserRest {

    private long id;
    private String carUserId;
    private long userId;
    private int carMilages;
    private int numberOfKilomentersPerMonth;
    private long carModelId;


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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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
