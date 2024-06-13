package model.vehicle;

import model.base.Rental;
import model.base.Vehicle;
import model.base.constants.VehicleStatus;

import java.util.Set;

public class Car extends Vehicle {
    private int rating;
    private boolean isHighlySafely;

    public Car(String brand,
               String model,
               Double value,
               int shortRentedDailyPrice,
               int longRentedDailyPrice,
               VehicleStatus status,
               Set<Rental> rentals,
               int rating) {
        super(brand, model, value, shortRentedDailyPrice, longRentedDailyPrice, status, rentals);
        this.rating = rating;
        this.isHighlySafely = isCarHighlySafely(rating);
    }
    private boolean isCarHighlySafely(int rating){
        return rating >= 4;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isHighlySafely() {
        return isHighlySafely;
    }

    public void setHighlySafely(boolean highlySafely) {
        isHighlySafely = highlySafely;
    }
}
