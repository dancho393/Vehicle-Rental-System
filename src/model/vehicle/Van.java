package model.vehicle;

import model.Rental;
import model.base.Vehicle;
import model.user.LoggedUser;

import java.util.Set;

public class Van extends Vehicle {


    public Van(String brand, String model, Double value, Double shortPeriodRentalPrice, Double longPeriodRentalPrice, Set<Rental> rentals, Double insurancePercentagePerDay) {
        super(brand, model, value, shortPeriodRentalPrice, longPeriodRentalPrice, rentals, insurancePercentagePerDay);
    }

    @Override
    public String toString() {
        return "The Driver Has: "+ LoggedUser.getInstance().getUser().getDrivingExperience()+" Years Experience";
    }
}
