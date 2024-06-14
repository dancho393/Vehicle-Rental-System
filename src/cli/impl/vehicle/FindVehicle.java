package cli.impl.vehicle;

import cli.command.vehicle.find.FindVehicleCommand;
import cli.command.vehicle.find.FindVehicleRequest;
import cli.command.vehicle.find.FindVehicleResponse;
import model.base.Vehicle;
import model.vehicle.VehicleRental;

import java.util.Set;

public class FindVehicle implements FindVehicleCommand {
    @Override
    public FindVehicleResponse execute(FindVehicleRequest request) {
        Set<Vehicle> vehicles = VehicleRental.getInstance().getVehicles();
        for(Vehicle vehicle : vehicles) {
            if(request.getBrand().equalsIgnoreCase(vehicle.getBrand())
            && request.getModel().equalsIgnoreCase(vehicle.getModel())) {
                return new FindVehicleResponse(vehicle);
            }
        }
        return null;
    }
}
