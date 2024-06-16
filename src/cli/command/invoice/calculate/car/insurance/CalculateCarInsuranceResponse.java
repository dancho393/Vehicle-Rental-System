package cli.command.invoice.calculate.car.insurance;

import cli.base.CommandResponse;

public class CalculateCarInsuranceResponse implements CommandResponse {
    private double initialInsurancePerDay;
    private double discountPerDay;
    private double earlyReturnDiscount;
    private double highSafetyDiscount;
    private double totalInsurance;

    public CalculateCarInsuranceResponse(double initialInsurancePerDay, double discountPerDay, double earlyReturnDiscount, double highSafetyDiscount, double totalInsurance) {
        this.initialInsurancePerDay = initialInsurancePerDay;
        this.discountPerDay = discountPerDay;
        this.earlyReturnDiscount = earlyReturnDiscount;
        this.highSafetyDiscount = highSafetyDiscount;
        this.totalInsurance = totalInsurance;
    }

    @Override
    public String toString() {
        return "CalculateCarInsuranceResponse{" +
                "initialInsurancePerDay=" + initialInsurancePerDay +
                ", discountPerDay=" + discountPerDay +
                ", earlyReturnDiscount=" + earlyReturnDiscount +
                ", highSafetyDiscount=" + highSafetyDiscount +
                ", totalInsurance=" + totalInsurance +
                '}';
    }

    public double getInitialInsurancePerDay() {
        return initialInsurancePerDay;
    }

    public void setInitialInsurancePerDay(double initialInsurancePerDay) {
        this.initialInsurancePerDay = initialInsurancePerDay;
    }

    public double getDiscountPerDay() {
        return discountPerDay;
    }

    public void setDiscountPerDay(double discountPerDay) {
        this.discountPerDay = discountPerDay;
    }

    public double getEarlyReturnDiscount() {
        return earlyReturnDiscount;
    }

    public void setEarlyReturnDiscount(double earlyReturnDiscount) {
        this.earlyReturnDiscount = earlyReturnDiscount;
    }

    public double getHighSafetyDiscount() {
        return highSafetyDiscount;
    }

    public void setHighSafetyDiscount(double highSafetyDiscount) {
        this.highSafetyDiscount = highSafetyDiscount;
    }

    public double getTotalInsurance() {
        return totalInsurance;
    }

    public void setTotalInsurance(double totalInsurance) {
        this.totalInsurance = totalInsurance;
    }
}
