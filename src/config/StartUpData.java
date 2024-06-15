package config;

import cli.command.invoice.calculate.car.insurance.CalculateCarInsuranceCommand;
import cli.command.invoice.calculate.car.rental.CalculateCarRentalCommand;
import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceCommand;
import cli.command.rental.create.CreateRentalCommand;
import cli.command.rental.create.CreateRentalRequest;
import cli.command.user.create.CreateUserCommand;
import cli.command.user.create.CreateUserRequest;
import cli.command.vehicle.find.FindVehicleCommand;
import cli.impl.invoice.CalculateCarInsurance;
import cli.impl.invoice.CalculateCarRental;
import cli.impl.invoice.CalculateMotorcycleInsurance;
import cli.impl.rental.CreateRental;
import cli.impl.user.CreateUser;
import cli.impl.vehicle.FindVehicle;
import model.base.Vehicle;
import model.vehicle.Car;
import model.vehicle.Motorcycle;
import model.vehicle.Van;
import model.vehicle.VehicleRental;

import java.time.LocalDate;
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
                3,
                22);
        CreateUserCommand command = new CreateUser();
        System.out.println(command.execute(request).getMessage());
    }
    private void  createVehicles(){
        Vehicle vehicle = new Car("BMW","540i",15000.0,20.0,15.0,new HashSet<>(),0.01,3);
        Vehicle vehicle1 = new Motorcycle("Honda","600cc",10000.0,15.0,10.0,new HashSet<>(),0.02);
        Vehicle vehicle2 = new Van("Mercedes","V2000",70000.0,50.0,40.0,new HashSet<>(),0.03);
        VehicleRental.getInstance().addVehicle(vehicle);
        VehicleRental.getInstance().addVehicle(vehicle1);
        VehicleRental.getInstance().addVehicle(vehicle2);
        createRental(vehicle);
        createRental(vehicle1);

    }
    private void createRental(Vehicle vehicle){

            CreateRentalRequest request = new CreateRentalRequest(
                    vehicle.getBrand(),
                    vehicle.getModel(),
                    LocalDate.parse("2024-06-03"),
                    LocalDate.parse("2024-06-13"),
                    LocalDate.parse("2024-06-13"),
                    10,
                    10
            );
            FindVehicleCommand findVehicleCommand = new FindVehicle();
            CalculateCarInsuranceCommand calculateCarInsuranceCommand= new CalculateCarInsurance();
        CalculateCarRentalCommand calculateCarRentalCommand = new CalculateCarRental();
        CalculateMotorcycleInsuranceCommand calculateMotorcycleInsuranceCommand = new CalculateMotorcycleInsurance();

            CreateRentalCommand createRentalCommand = new CreateRental(
                            findVehicleCommand,
                            calculateCarInsuranceCommand,
                            calculateCarRentalCommand,
                            calculateMotorcycleInsuranceCommand);
            System.out.println(createRentalCommand.execute(request).toString());
        }

}
