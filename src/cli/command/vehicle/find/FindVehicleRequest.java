package cli.command.vehicle.find;

import cli.base.CommandRequest;

public class FindVehicleRequest implements CommandRequest {
    private String brand;
    private String model;

    public FindVehicleRequest(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
