package com.car.asistant.demo.entity;

import javax.persistence.*;

@Entity
public class CarUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 45)
    private String carUserId;
    @Column(nullable = false, length = 45)
    private int carMilages;
    @Column(nullable = false, length = 45)
    private int numberOfKilomentersPerMonth;
    @Column(nullable = false, length = 45)
    private int kilometersSinceTheLastChangeBraekPads;
    @Column(nullable = false, length = 45)
    private int kilometersSinceTheLastChangeOil;
    @Column(nullable = false, length = 45)
    private int kilometersSinceTheLastChangeTimingGear;


    @ManyToOne
    @JoinColumn(name = "carModel")
    private CarModelEntity carModel;

    @ManyToOne
    @JoinColumn(name = "users")
    private UserEntity user;

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

    public CarModelEntity getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModelEntity carModel) {
        this.carModel = carModel;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
