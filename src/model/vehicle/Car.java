package model.vehicle;

import model.Rental;
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
               Double insurancePercentagePerDay,
               int rating) {
        super(brand, model, value, shortPeriodRentalPrice, longPeriodRentalPrice, rentals, insurancePercentagePerDay);
        this.rating = rating;
        this.isHighlySafe = checkIsHighlySafe(rating);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isHighlySafe() {
        return isHighlySafe;
    }

    public void setHighlySafe(boolean highlySafe) {
        isHighlySafe = highlySafe;
    }

    private boolean checkIsHighlySafe(int rating){
        return rating>=4;
    };

    @Override
    public String toString() {
        return "This Car Has Rating: " + rating ;
    }
}
