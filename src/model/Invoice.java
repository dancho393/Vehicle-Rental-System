package model;

import model.base.Rental;

public class Invoice {
    private Rental rental;
    private Double rentalCostPerDay;
    private Double insuranceCostPerDay;
    private Double totalRentCost;
    private Double totalInsuranceCost;
    private Double totalTax;

    public Invoice(Rental rental, Double rentalCostPerDay, Double insuranceCostPerDay, Double totalRentCost, Double totalInsuranceCost, Double totalTax) {
        this.rental = rental;
        this.rentalCostPerDay = rentalCostPerDay;
        this.insuranceCostPerDay = insuranceCostPerDay;
        this.totalRentCost = totalRentCost;
        this.totalInsuranceCost = totalInsuranceCost;
        this.totalTax = totalTax;
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

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }
}
