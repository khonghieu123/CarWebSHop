package com.javawebcar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Car {
    @Id
    private String registrationNumber;
    
    @Column(name="userID")
    private Long userID;
    
    private String carManufacturer;
    private String carModel;
    private String carColor;
    private Integer fabricationYear;
    private Integer cylinderCapacity;
    private String fuelType;
    private Integer carPower;
    private Integer engineCouple;
    private Integer trunkVolume;
    private Integer carPrice;

    public Car() {
    }

    public Car(String registrationNumber, String carManufacturer, String carModel, String carColor, Integer fabricationYear, Integer cylinderCapacity, String fuelType, Integer carPower, Integer engineCouple, Integer trunkVolume, Integer carPrice) {
        this.registrationNumber = registrationNumber;
        this.carManufacturer = carManufacturer;
        this.carModel = carModel;
        this.carColor = carColor;
        this.fabricationYear = fabricationYear;
        this.cylinderCapacity = cylinderCapacity;
        this.fuelType = fuelType;
        this.carPower = carPower;
        this.engineCouple = engineCouple;
        this.trunkVolume = trunkVolume;
        this.carPrice = carPrice;
    }

    public Car(String registrationNumber, Long userID, String carManufacturer, String carModel, String carColor, Integer fabricationYear, Integer cylinderCapacity, String fuelType, Integer carPower, Integer engineCouple, Integer trunkVolume, Integer carPrice) {
        this.registrationNumber = registrationNumber;
        this.userID = userID;
        this.carManufacturer = carManufacturer;
        this.carModel = carModel;
        this.carColor = carColor;
        this.fabricationYear = fabricationYear;
        this.cylinderCapacity = cylinderCapacity;
        this.fuelType = fuelType;
        this.carPower = carPower;
        this.engineCouple = engineCouple;
        this.trunkVolume = trunkVolume;
        this.carPrice = carPrice;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(Integer fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public Integer getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(Integer cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getCarPower() {
        return carPower;
    }

    public void setCarPower(Integer carPower) {
        this.carPower = carPower;
    }

    public Integer getEngineCouple() {
        return engineCouple;
    }

    public void setEngineCouple(Integer engineCouple) {
        this.engineCouple = engineCouple;
    }

    public Integer getTrunkVolume() {
        return trunkVolume;
    }

    public void setTrunkVolume(Integer trunkVolume) {
        this.trunkVolume = trunkVolume;
    }

    public Integer getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Integer carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
}
