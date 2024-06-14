package config;

import cli.command.user.create.CreateUserCommand;
import cli.command.user.create.CreateUserRequest;
import cli.impl.user.CreateUser;
import model.base.Vehicle;
import model.vehicle.Car;
import model.vehicle.Motorcycle;
import model.vehicle.Van;
import model.vehicle.VehicleRental;

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
        Vehicle vehicle = new Car("BMW","540i",50000.0,20.0,15.0,new HashSet<>(),4);
        Vehicle vehicle1 = new Motorcycle("Honda","600cc",20000.0,15.0,10.0,new HashSet<>());
        Vehicle vehicle2 = new Van("Mercedes","V2000",70000.0,50.0,40.0,new HashSet<>());
        VehicleRental.getInstance().addVehicle(vehicle);
        VehicleRental.getInstance().addVehicle(vehicle1);
        VehicleRental.getInstance().addVehicle(vehicle2);

    }
}
