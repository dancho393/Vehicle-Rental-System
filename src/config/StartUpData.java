package config;

import cli.command.invoice.calculate.car.insurance.CalculateCarInsuranceCommand;

import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceCommand;
import cli.command.invoice.calculate.rental.CalculateVehicleRentalCommand;
import cli.command.invoice.calculate.van.insurance.CalculateVanInsuranceCommand;
import cli.command.invoice.create.CreateInvoiceCommand;
import cli.command.rental.create.CreateRentalCommand;
import cli.command.rental.create.CreateRentalRequest;
import cli.command.user.create.CreateUserCommand;
import cli.command.user.create.CreateUserRequest;
import cli.command.vehicle.find.FindVehicleCommand;
import cli.impl.invoice.*;
import cli.impl.rental.CreateRental;
import cli.impl.user.CreateUser;
import cli.impl.vehicle.FindVehicle;
import model.base.Vehicle;
import model.vehicle.Car;
import model.vehicle.Motorcycle;
import model.vehicle.Van;
import model.vehicle.VehicleRental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

public class StartUpData {
    public StartUpData() {
    }
    public void run() {
        createUser();
        createVehicles();

    }
    private void createUser() {
        CreateUserRequest request = new CreateUserRequest(
                "Yordan",
                "Yordanov",
                "danez7000@gmail.com",
                8,
                22);
        CreateUserCommand command = new CreateUser();
        System.out.println(command.execute(request).getMessage());
    }
    private void  createVehicles(){
        Vehicle vehicle = new Car("BMW","540i",15000.0,20.0,15.0,new HashSet<>(),0.01,3);
        Vehicle vehicle1 = new Motorcycle("Honda","600cc",10000.0,15.0,10.0,new HashSet<>(),0.02);
        Vehicle vehicle2 = new Van("Mercedes","V2000",20000.0,50.0,40.0,new HashSet<>(),0.03);
        VehicleRental.getInstance().addVehicle(vehicle);
        VehicleRental.getInstance().addVehicle(vehicle1);
        VehicleRental.getInstance().addVehicle(vehicle2);
        createRental(
                vehicle,
                LocalDate.parse("2023-06-06"),
                LocalDate.parse("2023-06-16"),
                LocalDate.parse("2023-06-16"));
        createRental(vehicle1,
                LocalDate.parse("2023-06-06"),
                LocalDate.parse("2023-06-16"),
                LocalDate.parse("2023-06-16"));
        createRental(vehicle2,
                LocalDate.parse("2023-06-06"),
                LocalDate.parse("2023-06-21"),
                LocalDate.parse("2023-06-16"));

    }
    private void createRental(
            Vehicle vehicle,
            LocalDate startDate,
            LocalDate returnDate,
            LocalDate actualReturnDate){

            CreateRentalRequest request = new CreateRentalRequest(
                    vehicle.getBrand(),
                    vehicle.getModel(),
                    startDate,
                    returnDate,
                    actualReturnDate,
                    (int) ChronoUnit.DAYS.between(startDate, returnDate),
                    (int) ChronoUnit.DAYS.between(startDate, actualReturnDate)
            );
            FindVehicleCommand findVehicleCommand = new FindVehicle();
            CalculateCarInsuranceCommand calculateCarInsuranceCommand= new CalculateCarInsurance();
        CalculateVehicleRentalCommand calculateCarRentalCommand = new CalculateCarRental();
        CalculateMotorcycleInsuranceCommand calculateMotorcycleInsuranceCommand = new CalculateMotorcycleInsurance();
        CalculateVanInsuranceCommand calculateVanInsuranceCommand = new CalculateVanInsurance();
        CreateInvoiceCommand createInvoiceCommand = new CreateInvoice();

            CreateRentalCommand createRentalCommand = new CreateRental(
                            findVehicleCommand,
                            calculateCarInsuranceCommand,
                            calculateCarRentalCommand,
                            calculateMotorcycleInsuranceCommand,
                            calculateVanInsuranceCommand,
                            createInvoiceCommand);
            System.out.println(createRentalCommand.execute(request).toString()+"\n\n");
        }

}
