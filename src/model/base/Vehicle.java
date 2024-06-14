package model.base;

import java.util.Set;

public abstract class Vehicle {
    private String brand;
    private String model;
    private Double value;
    private Double shortPeriodRentalPrice;//less than week
    private Double longPeriodRentalPrice;//more than weak
    private Set<Rental> rentals;
    private Double insurancePercentagePerDay;

    public Vehicle(String brand, String model, Double value, Double shortPeriodRentalPrice, Double longPeriodRentalPrice, Set<Rental> rentals, Double insurancePercentagePerDay) {
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.shortPeriodRentalPrice = shortPeriodRentalPrice;
        this.longPeriodRentalPrice = longPeriodRentalPrice;
        this.rentals = rentals;
        this.insurancePercentagePerDay = insurancePercentagePerDay;
    }

    public Double getInsurancePercentagePerDay() {
        return insurancePercentagePerDay;
    }

    public void setInsurancePercentagePerDay(Double insurancePercentagePerDay) {
        this.insurancePercentagePerDay = insurancePercentagePerDay;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getShortPeriodRentalPrice() {
        return shortPeriodRentalPrice;
    }

    public void setShortPeriodRentalPrice(Double shortPeriodRentalPrice) {
        this.shortPeriodRentalPrice = shortPeriodRentalPrice;
    }

    public Double getLongPeriodRentalPrice() {
        return longPeriodRentalPrice;
    }

    public void setLongPeriodRentalPrice(Double longPeriodRentalPrice) {
        this.longPeriodRentalPrice = longPeriodRentalPrice;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }
}
