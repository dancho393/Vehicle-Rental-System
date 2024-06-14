package cli.impl.rental;

import cli.command.invoice.calculate.insurance.CalculateCarInsuranceCommand;
import cli.command.invoice.calculate.insurance.CalculateCarInsuranceRequest;
import cli.command.rental.create.CreateRentalCommand;
import cli.command.rental.create.CreateRentalRequest;
import cli.command.rental.create.CreateRentalResponse;
import cli.command.vehicle.find.FindVehicleCommand;
import cli.command.vehicle.find.FindVehicleRequest;
import model.base.Vehicle;
import model.vehicle.Car;

public class CreateRental implements CreateRentalCommand {
    private final FindVehicleCommand findVehicleCommand;
    private final CalculateCarInsuranceCommand calculateCarInsuranceCommand;

    public CreateRental(FindVehicleCommand findVehicleCommand, CalculateCarInsuranceCommand calculateCarInsuranceCommand) {
        this.findVehicleCommand = findVehicleCommand;
        this.calculateCarInsuranceCommand = calculateCarInsuranceCommand;
    }

    @Override
    public CreateRentalResponse execute(CreateRentalRequest request) {
        Vehicle vehicle = findVehicleCommand.execute(
                buildFindVehicleRequest(request.getBrand(), request.getModel())).getVehicle();
        if(vehicle == null) {
            return new CreateRentalResponse(null,"Vehicle Was not found");
        }
        if(vehicle instanceof Car){
            CalculateCarInsuranceRequest request1 =
                    new CalculateCarInsuranceRequest((Car)vehicle,request.getDays(), request.getActualDays() );
            System.out.println(calculateCarInsuranceCommand.execute(request1));
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
