package model.base;

import model.Invoice;

import java.time.LocalDate;


public class Rental {
    private LocalDate fromDate;
    private LocalDate returnDate;
    private Vehicle vehicle;
    private LocalDate actualReturn;
    private int days;
    private int actualDays;
    private Invoice invoice;

    public Rental(LocalDate fromDate, LocalDate returnDate, Vehicle vehicle, LocalDate actualReturn, Invoice invoice) {
        this.fromDate = fromDate;
        this.returnDate = returnDate;
        this.vehicle = vehicle;
        this.actualReturn = actualReturn;
        this.invoice = invoice;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getActualReturn() {
        return actualReturn;
    }

    public void setActualReturn(LocalDate actualReturn) {
        this.actualReturn = actualReturn;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
