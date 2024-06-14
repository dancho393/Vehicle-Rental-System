package cli.impl.rental;

import cli.command.invoice.calculate.insurance.CalculateCarInsuranceCommand;
import cli.command.invoice.calculate.insurance.CalculateCarInsuranceRequest;
import cli.command.invoice.calculate.insurance.CalculateCarInsuranceResponse;
import cli.command.invoice.calculate.rental.CalculateCarRentalCommand;
import cli.command.invoice.calculate.rental.CalculateCarRentalRequest;
import cli.command.invoice.calculate.rental.CalculateCarRentalResponse;
import cli.command.rental.create.CreateRentalCommand;
import cli.command.rental.create.CreateRentalRequest;
import cli.command.rental.create.CreateRentalResponse;
import cli.command.vehicle.find.FindVehicleCommand;
import cli.command.vehicle.find.FindVehicleRequest;
import model.Invoice;
import model.base.Rental;
import model.base.Vehicle;
import model.vehicle.Car;

public class CreateRental implements CreateRentalCommand {
    private final FindVehicleCommand findVehicleCommand;
    private final CalculateCarInsuranceCommand calculateCarInsuranceCommand;
    private final CalculateCarRentalCommand calculateCarRentalCommand;

    public CreateRental(FindVehicleCommand findVehicleCommand, CalculateCarInsuranceCommand calculateCarInsuranceCommand, CalculateCarRentalCommand calculateCarRentalCommand) {
        this.findVehicleCommand = findVehicleCommand;
        this.calculateCarInsuranceCommand = calculateCarInsuranceCommand;
        this.calculateCarRentalCommand = calculateCarRentalCommand;
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

//            System.out.println(rentalResponse.toString());
//            System.out.println(insuranceResponse.toString());
//            System.out.println("Total Price:"+rentalResponse.getRentalPrice()+insuranceResponse.getTotalInsurance());
            return new CreateRentalResponse(rental.toString(),"Rental Created");
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
