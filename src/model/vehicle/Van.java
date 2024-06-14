package model.vehicle;

import model.base.Rental;
import model.base.Vehicle;

import java.util.Set;

public class Van extends Vehicle {

    public Van(String brand, String model, Double value, Double shortPeriodRentalPrice, Double longPeriodRentalPrice, Set<Rental> rentals) {
        super(brand, model, value, shortPeriodRentalPrice, longPeriodRentalPrice, rentals);
    }
}
