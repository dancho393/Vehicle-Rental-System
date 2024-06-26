package model;

import model.base.Vehicle;
import model.vehicle.Car;

import java.time.LocalDate;


public class Rental {
    private LocalDate fromDate;
    private LocalDate returnDate;
    private Vehicle vehicle;
    private LocalDate actualReturn;
    private int days;
    private int actualDays;
    private Invoice invoice;


    public Rental(int actualDays, int days, LocalDate actualReturn, Vehicle vehicle, LocalDate returnDate, LocalDate fromDate) {
        this.actualDays = actualDays;
        this.days = days;
        this.actualReturn = actualReturn;
        this.vehicle = vehicle;
        this.returnDate = returnDate;
        this.fromDate = fromDate;
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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {

        return "Rented Vehicle: " +vehicle.getBrand()+" "+vehicle.getModel()+"\n"+"And "+ vehicle.toString()
                + "From Date: "+fromDate+"\n"
                + "Return Date: "+returnDate
                +"\n"+"Days: "+days+"\n"
                +"Actual/Days: "+actualDays+"\n"
                +"Rental Cost Per Day:"+invoice.getRentalPerDay()+"\n"
                +"Insurance Cost Per Day:"+invoice.getInsurancePerDay()+"\n"
                +"Discount Per Day:"+invoice.getDiscountPerDay()+"\n"
                +"Add Per Day:"+invoice.getAddPerDay()+"\n"

                +"Total Rent:"+invoice.getRentalPrice()+"\n"
                +"Total Insurance:"+invoice.getInsurancePrice()+"\n"
                +"Total Discount:"+invoice.getDiscountPrice()+"\n"
                +"Total Add:"+invoice.getAddPricey()+"\n"
                +"Total Price:"+invoice.getTotalPrice()+"\n\n\n\n";

    }
}
