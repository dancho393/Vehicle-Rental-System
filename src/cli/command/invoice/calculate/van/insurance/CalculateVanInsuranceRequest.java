package cli.command.invoice.calculate.van.insurance;

import cli.base.CommandRequest;
import model.base.Vehicle;

public class CalculateVanInsuranceRequest implements CommandRequest {
    private Vehicle vehicle;
    private int days;
    private int actualDays;

    public CalculateVanInsuranceRequest(Vehicle vehicle, int days, int actualDays) {
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
