package model.base;

import model.base.constants.VehicleStatus;

import java.util.HashSet;
import java.util.Set;

public abstract class Vehicle {
    private String brand;
    private String model;
    private Double value;
    private int shortRentedDailyPrice;//for less than a weak
    private int longRentedDailyPrice;//for more than a weak;
    private VehicleStatus status;
    private Set<Rental> rentals = new HashSet<>();

    public Vehicle(String brand, String model, Double value, int shortRentedDailyPrice, int longRentedDailyPrice, VehicleStatus status, Set<Rental> rentals) {
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.shortRentedDailyPrice = shortRentedDailyPrice;
        this.longRentedDailyPrice = longRentedDailyPrice;
        this.status = status;
        this.rentals = rentals;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getShortRentedDailyPrice() {
        return shortRentedDailyPrice;
    }

    public void setShortRentedDailyPrice(int shortRentedDailyPrice) {
        this.shortRentedDailyPrice = shortRentedDailyPrice;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getLongRentedDailyPrice() {
        return longRentedDailyPrice;
    }

    public void setLongRentedDailyPrice(int longRentedDailyPrice) {
        this.longRentedDailyPrice = longRentedDailyPrice;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }
}
