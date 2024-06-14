package cli.impl.rental;

import cli.command.rental.create.CreateRentalCommand;
import cli.command.rental.create.CreateRentalRequest;
import cli.command.rental.create.CreateRentalResponse;
import cli.command.vehicle.find.FindVehicleCommand;
import cli.command.vehicle.find.FindVehicleRequest;
import model.base.Vehicle;

public class CreateRental implements CreateRentalCommand {
    private  FindVehicleCommand findVehicleCommand;

    public CreateRental(FindVehicleCommand findVehicleCommand) {
        this.findVehicleCommand = findVehicleCommand;
    }

    @Override
    public CreateRentalResponse execute(CreateRentalRequest request) {
        Vehicle vehicle = findVehicleCommand.execute(
                buildFindVehicleRequest(request.getBrand(), request.getModel())).getVehicle();
        if(vehicle == null) {
            return new CreateRentalResponse(null,"Vehicle Was not found");
        }

        return null;
    }
    private FindVehicleRequest buildFindVehicleRequest(
            String brand,
            String model
    ){
        return new FindVehicleRequest(brand, model);
    }
}
