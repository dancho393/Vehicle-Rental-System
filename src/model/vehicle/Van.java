package model.vehicle;

import model.base.Rental;
import model.base.Vehicle;
import model.base.constants.VehicleStatus;

import java.util.Set;

public class Van extends Vehicle {
    public Van(String brand, String model, Double value, int shortRentedDailyPrice, int longRentedDailyPrice, VehicleStatus status, Set<Rental> rentals) {
        super(brand, model, value, shortRentedDailyPrice, longRentedDailyPrice, status, rentals);
    }
}