package model.vehicle;

import model.Rental;
import model.base.Vehicle;
import model.user.LoggedUser;

import java.util.Set;

public class Motorcycle extends Vehicle {

    public Motorcycle(String brand, String model, Double value, Double shortPeriodRentalPrice, Double longPeriodRentalPrice, Set<Rental> rentals, Double insurancePercentagePerDay) {
        super(brand, model, value, shortPeriodRentalPrice, longPeriodRentalPrice, rentals, insurancePercentagePerDay);
    }

    @Override
    public String toString() {
        return "This Driver Is:" + LoggedUser.getInstance().getUser().getAge()+" Years Old";
    }
}
