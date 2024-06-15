package cli.impl.rental;

import cli.command.invoice.calculate.car.insurance.CalculateCarInsuranceCommand;
import cli.command.invoice.calculate.car.insurance.CalculateCarInsuranceRequest;
import cli.command.invoice.calculate.car.insurance.CalculateCarInsuranceResponse;
import cli.command.invoice.calculate.car.rental.CalculateCarRentalCommand;
import cli.command.invoice.calculate.car.rental.CalculateCarRentalRequest;
import cli.command.invoice.calculate.car.rental.CalculateCarRentalResponse;
import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceCommand;
import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceRequest;
import cli.command.rental.create.CreateRentalCommand;
import cli.command.rental.create.CreateRentalRequest;
import cli.command.rental.create.CreateRentalResponse;
import cli.command.vehicle.find.FindVehicleCommand;
import cli.command.vehicle.find.FindVehicleRequest;
import model.Invoice;
import model.base.Rental;
import model.base.Vehicle;
import model.vehicle.Car;
import model.vehicle.Motorcycle;

public class CreateRental implements CreateRentalCommand {
    private final FindVehicleCommand findVehicleCommand;
    private final CalculateCarInsuranceCommand calculateCarInsuranceCommand;
    private final CalculateCarRentalCommand calculateCarRentalCommand;
    private final CalculateMotorcycleInsuranceCommand calculateMotorcycleInsuranceCommand;

    public CreateRental(FindVehicleCommand findVehicleCommand, CalculateCarInsuranceCommand calculateCarInsuranceCommand, CalculateCarRentalCommand calculateCarRentalCommand, CalculateMotorcycleInsuranceCommand calculateMotorcycleInsuranceCommand) {
        this.findVehicleCommand = findVehicleCommand;
        this.calculateCarInsuranceCommand = calculateCarInsuranceCommand;
        this.calculateCarRentalCommand = calculateCarRentalCommand;
        this.calculateMotorcycleInsuranceCommand = calculateMotorcycleInsuranceCommand;
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
            CalculateCarRentalRequest rentalRequest = new CalculateCarRentalRequest(vehicle, request.getDays(),request.getActualDays() );
            CalculateCarRentalResponse rentalResponse = calculateCarRentalCommand.execute(rentalRequest);
            CalculateCarInsuranceResponse insuranceResponse = calculateCarInsuranceCommand.execute(request1);
            Rental rental = new Rental(
                    request.getActualDays(),
                    request.getDays(),
                    request.getActualReturn(),
                    vehicle,
                    request.getReturnDate(),
                    request.getFromDate());

            Invoice invoice = new Invoice(
                    rental,
                    rentalResponse.getPricePerDay(),
                    insuranceResponse.getInitialInsurancePerDay(),
                    rentalResponse.getRentalPrice(),
                    insuranceResponse.getTotalInsurance(),
                    (insuranceResponse.getEarlyReturnDiscount()+insuranceResponse.getHighSafetyDiscount()),
                    (rentalResponse.getRentalPrice()+insuranceResponse.getTotalInsurance())
                    );
            rental.setInvoice(invoice);

            return new CreateRentalResponse(rental.toString(),"Rental Created");
        }
        else if(vehicle instanceof Motorcycle){
            CalculateMotorcycleInsuranceRequest calculateMotorcycleInsuranceRequest =
                    new CalculateMotorcycleInsuranceRequest(
                            (Motorcycle)vehicle,
                            10,
                            10
                    );
            System.out.println(calculateMotorcycleInsuranceCommand.execute(calculateMotorcycleInsuranceRequest).toString());

        }


        return new CreateRentalResponse(null,"Some Error");
    }

    private FindVehicleRequest buildFindVehicleRequest(
            String brand,
            String model
    ){
        return new FindVehicleRequest(brand, model);
    }
}
