package cli.impl.rental;

import cli.command.invoice.calculate.car.insurance.CalculateCarInsuranceCommand;
import cli.command.invoice.calculate.car.insurance.CalculateCarInsuranceRequest;
import cli.command.invoice.calculate.car.insurance.CalculateCarInsuranceResponse;

import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceCommand;
import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceRequest;
import cli.command.invoice.calculate.rental.CalculateVehicleRentalCommand;
import cli.command.invoice.calculate.rental.CalculateVehicleRentalRequest;
import cli.command.invoice.calculate.rental.CalculateVehicleRentalResponse;
import cli.command.invoice.calculate.van.insurance.CalculateVanInsuranceCommand;
import cli.command.invoice.calculate.van.insurance.CalculateVanInsuranceRequest;
import cli.command.invoice.calculate.van.insurance.CalculateVanInsuranceResponse;
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
import model.vehicle.Van;

public class CreateRental implements CreateRentalCommand {
    private final FindVehicleCommand findVehicleCommand;
    private final CalculateCarInsuranceCommand calculateCarInsuranceCommand;
    private final CalculateVehicleRentalCommand calculateCarRentalCommand;
    private final CalculateMotorcycleInsuranceCommand calculateMotorcycleInsuranceCommand;
    private final CalculateVanInsuranceCommand calculateVanInsuranceCommand;

    public CreateRental(FindVehicleCommand findVehicleCommand, CalculateCarInsuranceCommand calculateCarInsuranceCommand, CalculateVehicleRentalCommand calculateCarRentalCommand, CalculateMotorcycleInsuranceCommand calculateMotorcycleInsuranceCommand, CalculateVanInsuranceCommand calculateVanInsuranceCommand) {
        this.findVehicleCommand = findVehicleCommand;
        this.calculateCarInsuranceCommand = calculateCarInsuranceCommand;
        this.calculateCarRentalCommand = calculateCarRentalCommand;
        this.calculateMotorcycleInsuranceCommand = calculateMotorcycleInsuranceCommand;
        this.calculateVanInsuranceCommand = calculateVanInsuranceCommand;
    }

    @Override
    public CreateRentalResponse execute(CreateRentalRequest request) {
        Vehicle vehicle = findVehicleCommand.execute(
                buildFindVehicleRequest(request.getBrand(), request.getModel())).getVehicle();
        if(vehicle == null) {
            return new CreateRentalResponse(null,"Vehicle Was not found");
        }
        CalculateVehicleRentalRequest rentalRequest = new CalculateVehicleRentalRequest(vehicle, request.getDays(),request.getActualDays() );
        CalculateVehicleRentalResponse rentalResponse = calculateCarRentalCommand.execute(rentalRequest);
        System.out.println(rentalResponse.toString());
        if(vehicle instanceof Car){
            CalculateCarInsuranceRequest request1 =
                    new CalculateCarInsuranceRequest((Car)vehicle,request.getDays(), request.getActualDays() );

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
                            request.getDays(),
                            request.getActualDays()
                    );
            System.out.println(calculateMotorcycleInsuranceCommand.execute(calculateMotorcycleInsuranceRequest).toString());

        }
        else if(vehicle instanceof Van){
            CalculateVanInsuranceRequest calculateVanInsuranceRequest =
                    new CalculateVanInsuranceRequest(
                            (Van)vehicle,
                            request.getDays(),
                            request.getActualDays()
                    );
            CalculateVanInsuranceResponse response =calculateVanInsuranceCommand.execute(calculateVanInsuranceRequest);

            System.out.println(response.toString());

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
