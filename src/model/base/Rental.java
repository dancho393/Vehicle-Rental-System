package model.base;

import java.time.LocalDate;

public class Rental {
    private LocalDate fromDate;
    private LocalDate toDate;
    private Vehicle vehicle;

    public Rental(LocalDate fromDate, LocalDate toDate, Vehicle vehicle) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.vehicle = vehicle;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
