package model.vehicle;

import model.base.Rental;
import model.base.Vehicle;

import java.util.Set;

public class Motorcycle extends Vehicle {

    public Motorcycle(String brand, String model, Double value, Double shortPeriodRentalPrice, Double longPeriodRentalPrice, Set<Rental> rentals, Double insurancePercentagePerDay) {
        super(brand, model, value, shortPeriodRentalPrice, longPeriodRentalPrice, rentals, insurancePercentagePerDay);
    }
}
