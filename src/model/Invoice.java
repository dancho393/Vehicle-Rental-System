package model;

import model.base.Rental;

public class Invoice {
    private Rental rental;
    private Double rentalCostPerDay;
    private Double insuranceCostPerDay;
    private Double totalRentCost;
    private Double totalInsuranceCost;
    private Double discountedMoney;
    private Double totalPrice;

    public Invoice(Rental rental, Double rentalCostPerDay, Double insuranceCostPerDay, Double totalRentCost, Double totalInsuranceCost, Double discountedMoney, Double totalPrice) {
        this.rental = rental;
        this.rentalCostPerDay = rentalCostPerDay;
        this.insuranceCostPerDay = insuranceCostPerDay;
        this.totalRentCost = totalRentCost;
        this.totalInsuranceCost = totalInsuranceCost;
        this.discountedMoney = discountedMoney;
        this.totalPrice = totalPrice;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Double getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public void setRentalCostPerDay(Double rentalCostPerDay) {
        this.rentalCostPerDay = rentalCostPerDay;
    }

    public Double getInsuranceCostPerDay() {
        return insuranceCostPerDay;
    }

    public void setInsuranceCostPerDay(Double insuranceCostPerDay) {
        this.insuranceCostPerDay = insuranceCostPerDay;
    }

    public Double getTotalRentCost() {
        return totalRentCost;
    }

    public void setTotalRentCost(Double totalRentCost) {
        this.totalRentCost = totalRentCost;
    }

    public Double getTotalInsuranceCost() {
        return totalInsuranceCost;
    }

    public void setTotalInsuranceCost(Double totalInsuranceCost) {
        this.totalInsuranceCost = totalInsuranceCost;
    }

    public Double getDiscountedMoney() {
        return discountedMoney;
    }

    public void setDiscountedMoney(Double discountedMoney) {
        this.discountedMoney = discountedMoney;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
