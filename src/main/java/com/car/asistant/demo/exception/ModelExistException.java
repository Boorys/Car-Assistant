package com.car.asistant.demo.exception;

public class ModelExistException extends RuntimeException  {


    private final String carModel;

    public ModelExistException(String carModel) {
        super("Model exist with car model: " + carModel);
        this.carModel = carModel;
    }

    public String getCarModel() {
        return carModel;
    }
}
