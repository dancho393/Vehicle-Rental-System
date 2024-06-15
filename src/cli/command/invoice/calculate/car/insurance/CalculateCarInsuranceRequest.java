package cli.command.invoice.calculate.car.insurance;

import cli.base.CommandRequest;
import model.vehicle.Car;

public class CalculateCarInsuranceRequest implements CommandRequest {
    private Car car;
    private int days;
    private int actualDays;

    public CalculateCarInsuranceRequest(Car car, int days, int actualDays) {
        this.car = car;
        this.days = days;
        this.actualDays = actualDays;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getActualDays() {
        return actualDays;
    }

    public void setActualDays(int actualDays) {
        this.actualDays = actualDays;
    }
}
