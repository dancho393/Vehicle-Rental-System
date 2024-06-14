package cli.command.rental.create;

import cli.base.CommandRequest;
import model.base.Vehicle;

import java.time.LocalDate;

public class CreateRentalRequest implements CommandRequest {
    private String brand;
    private String model;
    private LocalDate fromDate;
    private LocalDate returnDate;
    private LocalDate actualReturn;
    private int days;
    private int actualDays;

    public CreateRentalRequest(String brand, String model, LocalDate fromDate, LocalDate returnDate, LocalDate actualReturn, int days, int actualDays) {
        this.brand = brand;
        this.model = model;
        this.fromDate = fromDate;
        this.returnDate = returnDate;
        this.actualReturn = actualReturn;
        this.days = days;
        this.actualDays = actualDays;
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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getActualReturn() {
        return actualReturn;
    }

    public void setActualReturn(LocalDate actualReturn) {
        this.actualReturn = actualReturn;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getActualDays() {
        return actualDays;
    }

    public void setActualDays(int actualDays) {
        this.actualDays = actualDays;
    }
}
