package cli.command.invoice.calculate.motorcycle.insurance;

import cli.base.CommandResponse;

public class CalculateMotorcycleInsuranceResponse implements CommandResponse {
    private double initialInsurancePerDay;
    private double initialInsurancePrice;
    private double expectedInsurancePrice;
    private double lowAgeInsurancePricePerDay;
    private double lowAgeInsurancePrice;
    private  double discountForEarlyReturn;
    private double discountPerDay;
    private double actualInsurancePricePerDay;
    private  double actualInsurancePrice;


    public CalculateMotorcycleInsuranceResponse(double initialInsurancePerDay, double initialInsurancePrice, double expectedInsurancePrice, double lowAgeInsurancePricePerDay, double lowAgeInsurancePrice, double discountForEarlyReturn, double discountPerDay, double actualInsurancePricePerDay, double actualInsurancePrice) {
        this.initialInsurancePerDay = initialInsurancePerDay;
        this.initialInsurancePrice = initialInsurancePrice;
        this.expectedInsurancePrice = expectedInsurancePrice;
        this.lowAgeInsurancePricePerDay = lowAgeInsurancePricePerDay;
        this.lowAgeInsurancePrice = lowAgeInsurancePrice;
        this.discountForEarlyReturn = discountForEarlyReturn;
        this.discountPerDay = discountPerDay;
        this.actualInsurancePricePerDay = actualInsurancePricePerDay;
        this.actualInsurancePrice = actualInsurancePrice;
    }

    public double getLowAgeInsurancePrice() {
        return lowAgeInsurancePrice;
    }

    public void setLowAgeInsurancePrice(double lowAgeInsurancePrice) {
        this.lowAgeInsurancePrice = lowAgeInsurancePrice;
    }

    public double getDiscountPerDay() {
        return discountPerDay;
    }

    public void setDiscountPerDay(double discountPerDay) {
        this.discountPerDay = discountPerDay;
    }

    @Override
    public String toString() {
        return "CalculateMotorcycleInsuranceResponse{" +
                "initialInsurancePerDay=" + initialInsurancePerDay +
                ", initialInsurancePrice=" + initialInsurancePrice +
                ", expectedInsurancePrice=" + expectedInsurancePrice +
                ", lowAgeInsurancePricePerDay=" + lowAgeInsurancePricePerDay +
                ", discountForEarlyReturn=" + discountForEarlyReturn +
                ", actualInsurancePricePerDay=" + actualInsurancePricePerDay +
                ", actualInsurancePrice=" + actualInsurancePrice +
                '}';
    }

    public double getInitialInsurancePerDay() {
        return initialInsurancePerDay;
    }

    public void setInitialInsurancePerDay(double initialInsurancePerDay) {
        this.initialInsurancePerDay = initialInsurancePerDay;
    }

    public double getInitialInsurancePrice() {
        return initialInsurancePrice;
    }

    public void setInitialInsurancePrice(double initialInsurancePrice) {
        this.initialInsurancePrice = initialInsurancePrice;
    }

    public double getExpectedInsurancePrice() {
        return expectedInsurancePrice;
    }

    public void setExpectedInsurancePrice(double expectedInsurancePrice) {
        this.expectedInsurancePrice = expectedInsurancePrice;
    }

    public double getLowAgeInsurancePricePerDay() {
        return lowAgeInsurancePricePerDay;
    }

    public void setLowAgeInsurancePricePerDay(double lowAgeInsurancePricePerDay) {
        this.lowAgeInsurancePricePerDay = lowAgeInsurancePricePerDay;
    }

    public double getDiscountForEarlyReturn() {
        return discountForEarlyReturn;
    }

    public void setDiscountForEarlyReturn(double discountForEarlyReturn) {
        this.discountForEarlyReturn = discountForEarlyReturn;
    }

    public double getActualInsurancePricePerDay() {
        return actualInsurancePricePerDay;
    }

    public void setActualInsurancePricePerDay(double actualInsurancePricePerDay) {
        this.actualInsurancePricePerDay = actualInsurancePricePerDay;
    }

    public double getActualInsurancePrice() {
        return actualInsurancePrice;
    }

    public void setActualInsurancePrice(double actualInsurancePrice) {
        this.actualInsurancePrice = actualInsurancePrice;
    }
}
