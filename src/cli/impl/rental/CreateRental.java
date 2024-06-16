package cli.impl.rental;

import cli.command.invoice.calculate.car.insurance.CalculateCarInsuranceCommand;
import cli.command.invoice.calculate.car.insurance.CalculateCarInsuranceRequest;
import cli.command.invoice.calculate.car.insurance.CalculateCarInsuranceResponse;

import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceCommand;
import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceRequest;
import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceResponse;
import cli.command.invoice.calculate.rental.CalculateVehicleRentalCommand;
import cli.command.invoice.calculate.rental.CalculateVehicleRentalRequest;
import cli.command.invoice.calculate.rental.CalculateVehicleRentalResponse;
import cli.command.invoice.calculate.van.insurance.CalculateVanInsuranceCommand;
import cli.command.invoice.calculate.van.insurance.CalculateVanInsuranceRequest;
import cli.command.invoice.calculate.van.insurance.CalculateVanInsuranceResponse;
import cli.command.invoice.create.CreateInvoiceCommand;
import cli.command.invoice.create.CreateInvoiceRequest;
import cli.command.rental.create.CreateRentalCommand;
import cli.command.rental.create.CreateRentalRequest;
import cli.command.rental.create.CreateRentalResponse;
import cli.command.vehicle.find.FindVehicleCommand;
import cli.command.vehicle.find.FindVehicleRequest;
import model.Rental;
import model.Invoice;
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
    private final CreateInvoiceCommand createInvoiceCommand;

    public CreateRental(FindVehicleCommand findVehicleCommand, CalculateCarInsuranceCommand calculateCarInsuranceCommand, CalculateVehicleRentalCommand calculateCarRentalCommand, CalculateMotorcycleInsuranceCommand calculateMotorcycleInsuranceCommand, CalculateVanInsuranceCommand calculateVanInsuranceCommand, CreateInvoiceCommand createInvoiceCommand) {
        this.findVehicleCommand = findVehicleCommand;
        this.calculateCarInsuranceCommand = calculateCarInsuranceCommand;
        this.calculateCarRentalCommand = calculateCarRentalCommand;
        this.calculateMotorcycleInsuranceCommand = calculateMotorcycleInsuranceCommand;
        this.calculateVanInsuranceCommand = calculateVanInsuranceCommand;
        this.createInvoiceCommand = createInvoiceCommand;
    }

    @Override
    public CreateRentalResponse execute(CreateRentalRequest request) {
        Vehicle vehicle = findVehicleCommand.execute(
                buildFindVehicleRequest(request.getBrand(), request.getModel())).getVehicle();
        if(vehicle == null) {
            return new CreateRentalResponse(null,"Vehicle Was not found");
        }
        Rental rental;
        Invoice invoice;
        CalculateVehicleRentalRequest rentalRequest = new CalculateVehicleRentalRequest(vehicle, request.getDays(),request.getActualDays() );
        CalculateVehicleRentalResponse rentalResponse = calculateCarRentalCommand.execute(rentalRequest);

        System.out.println(rentalResponse.toString());
        rental = new Rental(
                request.getActualDays(),
                request.getDays(),
                request.getActualReturn(),
                vehicle,
                request.getReturnDate(),
                request.getFromDate());
        if(vehicle instanceof Car){
            CalculateCarInsuranceRequest request1 =
                    new CalculateCarInsuranceRequest((Car)vehicle,request.getDays(), request.getActualDays() );

            CalculateCarInsuranceResponse insuranceResponse = calculateCarInsuranceCommand.execute(request1);


            System.out.println(insuranceResponse.toString());
            CreateInvoiceRequest createInvoiceRequest = new CreateInvoiceRequest(
                    rentalResponse.getPricePerDay(),
                    insuranceResponse.getInitialInsurancePerDay(),
                    insuranceResponse.getEarlyReturnDiscount()+insuranceResponse.getHighSafetyDiscount(),
                    0,
                    rentalResponse.getRentalPrice(),
                    insuranceResponse.getTotalInsurance(),
                    insuranceResponse.getEarlyReturnDiscount()+insuranceResponse.getHighSafetyDiscount(),
                    0,
                    rentalResponse.getRentalPrice()+insuranceResponse.getTotalInsurance(),
                    rental
            );
             invoice = createInvoiceCommand.execute(createInvoiceRequest).getInvoice();
            rental.setInvoice(invoice);

        }
        else if(vehicle instanceof Motorcycle){
            CalculateMotorcycleInsuranceRequest calculateMotorcycleInsuranceRequest =
                    new CalculateMotorcycleInsuranceRequest(
                            (Motorcycle)vehicle,
                            request.getDays(),
                            request.getActualDays()
                    );
            CalculateMotorcycleInsuranceResponse calculateMotorcycleInsuranceResponse =
                    calculateMotorcycleInsuranceCommand.execute(calculateMotorcycleInsuranceRequest);
            CreateInvoiceRequest createInvoiceRequest = new CreateInvoiceRequest(
                    rentalResponse.getPricePerDay(),
                    calculateMotorcycleInsuranceResponse.getInitialInsurancePerDay(),
                    calculateMotorcycleInsuranceResponse.getDiscountPerDay(),
                    calculateMotorcycleInsuranceResponse.getLowAgeInsurancePricePerDay(),
                    rentalResponse.getRentalPrice(),
                    calculateMotorcycleInsuranceResponse.getActualInsurancePrice(),
                    calculateMotorcycleInsuranceResponse.getDiscountPerDay(),
                    calculateMotorcycleInsuranceResponse.getLowAgeInsurancePrice(),
                    rentalResponse.getRentalPrice()+calculateMotorcycleInsuranceResponse.getActualInsurancePrice(),
                    rental
            );
             invoice = createInvoiceCommand.execute(createInvoiceRequest).getInvoice();
            rental.setInvoice(invoice);
            System.out.println(calculateMotorcycleInsuranceResponse.toString());

        }
        else if(vehicle instanceof Van){
            CalculateVanInsuranceRequest calculateVanInsuranceRequest =
                    new CalculateVanInsuranceRequest(
                            (Van)vehicle,
                            request.getDays(),
                            request.getActualDays()
                    );
            CalculateVanInsuranceResponse vanInsuranceResponse =calculateVanInsuranceCommand.execute(calculateVanInsuranceRequest);

            CreateInvoiceRequest createInvoiceRequest = new CreateInvoiceRequest(
                    rentalResponse.getPricePerDay(),
                    vanInsuranceResponse.getInitialInsurancePerDay(),
                    vanInsuranceResponse.getDiscountForEarlyReturnPerDay()+vanInsuranceResponse.getDiscountForExperiencePerDay(),
                    0,
                    rentalResponse.getRentalPrice(),
                    vanInsuranceResponse.getActualInsurancePrice(),
                    vanInsuranceResponse.getDiscountForEarlyReturn()+vanInsuranceResponse.getDiscountForExperience(),
                    0,
                    rentalResponse.getRentalPrice()+vanInsuranceResponse.getActualInsurancePrice(),
                    rental
            );
            invoice = createInvoiceCommand.execute(createInvoiceRequest).getInvoice();
            rental.setInvoice(invoice);
            System.out.println(vanInsuranceResponse.toString());

        }



        return new CreateRentalResponse(rental.toString(),"Rental Created");
    }

    private FindVehicleRequest buildFindVehicleRequest(
            String brand,
            String model
    ){
        return new FindVehicleRequest(brand, model);
    }
}
