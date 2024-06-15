package cli.command.invoice.calculate.rental;

import cli.base.CommandRequest;
import model.base.Vehicle;

public class CalculateVehicleRentalRequest implements CommandRequest {
    private Vehicle vehicle;
    private int days;
    private int actualDays;

    public CalculateVehicleRentalRequest(Vehicle vehicle, int days, int actualDays) {
        this.vehicle = vehicle;
        this.days = days;
        this.actualDays = actualDays;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
