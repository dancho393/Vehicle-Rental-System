package cli.command.invoice.calculate.van.insurance;

import cli.base.CommandResponse;

public class CalculateVanInsuranceResponse implements CommandResponse {
    private double initialInsurancePerDay;
    private double initialInsurancePrice;
    private double expectedInsurancePrice;
    private double priceWithExperiencePerDay;
    private  double discountForEarlyReturn;
    double discountForEarlyReturnPerDay;
    double discountForExperiencePerDay;
    double discountForExperience;
    private double actualInsurancePricePerDay;
    private  double actualInsurancePrice;


    public CalculateVanInsuranceResponse(double initialInsurancePerDay, double initialInsurancePrice, double expectedInsurancePrice, double priceWithExperiencePerDay, double discountForEarlyReturn, double discountForEarlyReturnPerDay, double discountForExperiencePerDay, double discountForExperience, double actualInsurancePricePerDay, double actualInsurancePrice) {
        this.initialInsurancePerDay = initialInsurancePerDay;
        this.initialInsurancePrice = initialInsurancePrice;
        this.expectedInsurancePrice = expectedInsurancePrice;
        this.priceWithExperiencePerDay = priceWithExperiencePerDay;
        this.discountForEarlyReturn = discountForEarlyReturn;
        this.discountForEarlyReturnPerDay = discountForEarlyReturnPerDay;
        this.discountForExperiencePerDay = discountForExperiencePerDay;
        this.discountForExperience = discountForExperience;
        this.actualInsurancePricePerDay = actualInsurancePricePerDay;
        this.actualInsurancePrice = actualInsurancePrice;
    }

    @Override
    public String toString() {
        return "CalculateVanInsuranceResponse{" +
                "initialInsurancePerDay=" + initialInsurancePerDay +
                ", initialInsurancePrice=" + initialInsurancePrice +
                ", expectedInsurancePrice=" + expectedInsurancePrice +
                ", priceWithExperiencePerDay=" + priceWithExperiencePerDay +
                ", discountForEarlyReturn=" + discountForEarlyReturn +
                ", discountForEarlyReturnPerDay=" + discountForEarlyReturnPerDay +
                ", discountForExperiencePerDay=" + discountForExperiencePerDay +
                ", discountForExperience=" + discountForExperience +
                ", actualInsurancePricePerDay=" + actualInsurancePricePerDay +
                ", actualInsurancePrice=" + actualInsurancePrice +
                '}';
    }

    public double getDiscountForExperience() {
        return discountForExperience;
    }

    public void setDiscountForExperience(double discountForExperience) {
        this.discountForExperience = discountForExperience;
    }

    public double getDiscountForEarlyReturnPerDay() {
        return discountForEarlyReturnPerDay;
    }

    public void setDiscountForEarlyReturnPerDay(double discountForEarlyReturnPerDay) {
        this.discountForEarlyReturnPerDay = discountForEarlyReturnPerDay;
    }

    public double getDiscountForExperiencePerDay() {
        return discountForExperiencePerDay;
    }

    public void setDiscountForExperiencePerDay(double discountForExperiencePerDay) {
        this.discountForExperiencePerDay = discountForExperiencePerDay;
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

    public double getPriceWithExperiencePerDay() {
        return priceWithExperiencePerDay;
    }

    public void setPriceWithExperiencePerDay(double priceWithExperiencePerDay) {
        this.priceWithExperiencePerDay = priceWithExperiencePerDay;
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
