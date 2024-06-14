package model.vehicle;

import model.base.Vehicle;

import java.util.HashSet;
import java.util.Set;

public class VehicleRental {
    private static VehicleRental INSTANCE;
    private Set<Vehicle> vehicles=new HashSet<>();
    private VehicleRental() {
    }
    public static VehicleRental getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VehicleRental();
        }
        return INSTANCE;
    }
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
    public Set<Vehicle> getVehicles() {
        return vehicles;
    }
    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
