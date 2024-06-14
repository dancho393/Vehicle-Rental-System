package cli.command.vehicle.find;

import cli.base.CommandResponse;
import model.base.Vehicle;

public class FindVehicleResponse implements CommandResponse {
    private Vehicle vehicle;

    public FindVehicleResponse(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
