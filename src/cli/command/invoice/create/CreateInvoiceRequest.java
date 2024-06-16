package cli.command.invoice.create;

import cli.base.CommandRequest;
import model.Rental;

public class CreateInvoiceRequest implements CommandRequest {
    private double rentalPerDay;
    private double insurancePerDay;
    private double discountPerDay;
    private double addPerDay;
    private double rentalPrice;
    private double insurancePrice;
    private double discountPrice;
    private double addPricey;
    private double totalPrice;
    private Rental rental;

    public CreateInvoiceRequest(double rentalPerDay, double insurancePerDay, double discountPerDay, double addPerDay, double rentalPrice, double insurancePrice, double discountPrice, double addPricey, double totalPrice, Rental rental) {
        this.rentalPerDay = rentalPerDay;
        this.insurancePerDay = insurancePerDay;
        this.discountPerDay = discountPerDay;
        this.addPerDay = addPerDay;
        this.rentalPrice = rentalPrice;
        this.insurancePrice = insurancePrice;
        this.discountPrice = discountPrice;
        this.addPricey = addPricey;
        this.totalPrice = totalPrice;
        this.rental = rental;
    }

    public double getRentalPerDay() {
        return rentalPerDay;
    }

    public void setRentalPerDay(double rentalPerDay) {
        this.rentalPerDay = rentalPerDay;
    }

    public double getInsurancePerDay() {
        return insurancePerDay;
    }

    public void setInsurancePerDay(double insurancePerDay) {
        this.insurancePerDay = insurancePerDay;
    }

    public double getDiscountPerDay() {
        return discountPerDay;
    }

    public void setDiscountPerDay(double discountPerDay) {
        this.discountPerDay = discountPerDay;
    }

    public double getAddPerDay() {
        return addPerDay;
    }

    public void setAddPerDay(double addPerDay) {
        this.addPerDay = addPerDay;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public double getAddPricey() {
        return addPricey;
    }

    public void setAddPricey(double addPricey) {
        this.addPricey = addPricey;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
