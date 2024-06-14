package cli.command.rental.create;

import cli.base.CommandRequest;

import java.time.LocalDate;

public class CreateRentalRequest implements CommandRequest {
    private String brand;
    private String model;
    private LocalDate fromDate;
    private LocalDate toDate;

    public CreateRentalRequest(String brand, String model, LocalDate fromDate, LocalDate toDate) {
        this.brand = brand;
        this.model = model;
        this.fromDate = fromDate;
        this.toDate = toDate;
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

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
