package model.vehicle;

import model.base.Rental;
import model.base.Vehicle;

import java.util.Set;

public class Car extends Vehicle {
    private int rating;
    private  boolean isHighlySafe;

    public Car(String brand,
               String model,
               Double value,
               Double shortPeriodRentalPrice,
               Double longPeriodRentalPrice,
               Set<Rental> rentals,
               int rating) {
        super(brand, model, value, shortPeriodRentalPrice, longPeriodRentalPrice, rentals);
        this.rating = rating;
        this.isHighlySafe = checkIsHighlySafe(rating);
    }
    private boolean checkIsHighlySafe(int rating){
        return rating>=4;
    };
}
