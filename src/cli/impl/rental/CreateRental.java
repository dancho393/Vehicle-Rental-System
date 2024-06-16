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
import model.user.LoggedUser;
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
        Vehicle vehicle = findVehicleCommand.execute(buildFindVehicleRequest(request.getBrand(), request.getModel())).getVehicle();
        if (vehicle == null) {
            return new CreateRentalResponse(null, "Vehicle was not found");
        }

        CalculateVehicleRentalResponse rentalResponse = calculateCarRentalCommand.execute(buildRentalRequest(vehicle, request));
        Rental rental = buildRental(vehicle, request);
        System.out.println(rentalResponse.toString());//Just To Be More Specific;

        Invoice invoice = calculateInsuranceAndCreateInvoice(vehicle, rental, rentalResponse, request);
        rental.setInvoice(invoice);
        LoggedUser.getInstance().getUser().getInvoices().add(invoice);

        return new CreateRentalResponse(rental.toString(), "Rental Created");
    }

    private FindVehicleRequest buildFindVehicleRequest(String brand, String model) {
        return new FindVehicleRequest(brand, model);
    }

    private CalculateVehicleRentalRequest buildRentalRequest(Vehicle vehicle, CreateRentalRequest request) {
        return new CalculateVehicleRentalRequest(vehicle, request.getDays(), request.getActualDays());
    }

    private Rental buildRental(Vehicle vehicle, CreateRentalRequest request) {
        return new Rental(
                request.getActualDays(),
                request.getDays(),
                request.getActualReturn(),
                vehicle,
                request.getReturnDate(),
                request.getFromDate());
    }

    private Invoice calculateInsuranceAndCreateInvoice(Vehicle vehicle, Rental rental, CalculateVehicleRentalResponse rentalResponse, CreateRentalRequest request) {
        if (vehicle instanceof Car) {
            CalculateCarInsuranceResponse insuranceResponse = calculateCarInsuranceCommand.execute(
                    new CalculateCarInsuranceRequest((Car) vehicle, request.getDays(), request.getActualDays()));
            System.out.println(insuranceResponse.toString());
            return createInvoiceCommand.execute(buildCarInvoiceRequest(rentalResponse, insuranceResponse, rental)).getInvoice();

        } else if (vehicle instanceof Motorcycle) {
            CalculateMotorcycleInsuranceResponse insuranceResponse = calculateMotorcycleInsuranceCommand.execute(
                    new CalculateMotorcycleInsuranceRequest((Motorcycle) vehicle, request.getDays(), request.getActualDays()));
            System.out.println(insuranceResponse.toString());
            return createInvoiceCommand.execute(buildMotorcycleInvoiceRequest(rentalResponse, insuranceResponse, rental)).getInvoice();

        } else if (vehicle instanceof Van) {
            CalculateVanInsuranceResponse insuranceResponse = calculateVanInsuranceCommand.execute(
                    new CalculateVanInsuranceRequest((Van) vehicle, request.getDays(), request.getActualDays()));
            System.out.println(insuranceResponse.toString());
            return createInvoiceCommand.execute(buildVanInvoiceRequest(rentalResponse, insuranceResponse, rental)).getInvoice();
        }

        throw new IllegalArgumentException("Unknown vehicle type");
    }

    private CreateInvoiceRequest buildCarInvoiceRequest(CalculateVehicleRentalResponse rentalResponse, CalculateCarInsuranceResponse insuranceResponse, Rental rental) {
        return new CreateInvoiceRequest(
                rentalResponse.getPricePerDay(),
                insuranceResponse.getInitialInsurancePerDay(),
                insuranceResponse.getEarlyReturnDiscount() + insuranceResponse.getHighSafetyDiscount(),
                0,
                rentalResponse.getRentalPrice(),
                insuranceResponse.getTotalInsurance(),
                insuranceResponse.getEarlyReturnDiscount() + insuranceResponse.getHighSafetyDiscount(),
                0,
                rentalResponse.getRentalPrice() + insuranceResponse.getTotalInsurance(),
                rental
        );
    }

    private CreateInvoiceRequest buildMotorcycleInvoiceRequest(CalculateVehicleRentalResponse rentalResponse, CalculateMotorcycleInsuranceResponse insuranceResponse, Rental rental) {
        return new CreateInvoiceRequest(
                rentalResponse.getPricePerDay(),
                insuranceResponse.getInitialInsurancePerDay(),
                insuranceResponse.getDiscountPerDay(),
                insuranceResponse.getLowAgeInsurancePricePerDay(),
                rentalResponse.getRentalPrice(),
                insuranceResponse.getActualInsurancePrice(),
                insuranceResponse.getDiscountPerDay(),
                insuranceResponse.getLowAgeInsurancePrice(),
                rentalResponse.getRentalPrice() + insuranceResponse.getActualInsurancePrice(),
                rental
        );
    }

    private CreateInvoiceRequest buildVanInvoiceRequest(CalculateVehicleRentalResponse rentalResponse, CalculateVanInsuranceResponse insuranceResponse, Rental rental) {
        return new CreateInvoiceRequest(
                rentalResponse.getPricePerDay(),
                insuranceResponse.getInitialInsurancePerDay(),
                insuranceResponse.getDiscountForEarlyReturnPerDay() + insuranceResponse.getDiscountForExperiencePerDay(),
                0,
                rentalResponse.getRentalPrice(),
                insuranceResponse.getActualInsurancePrice(),
                insuranceResponse.getDiscountForEarlyReturn() + insuranceResponse.getDiscountForExperience(),
                0,
                rentalResponse.getRentalPrice() + insuranceResponse.getActualInsurancePrice(),
                rental
        );
    }
}
