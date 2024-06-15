package cli.command.invoice.calculate.car.insurance;

import cli.base.CommandResponse;

public class CalculateCarInsuranceResponse implements CommandResponse {
    private double initialInsurancePerDay;

    private double earlyReturnDiscount;
    private double highSafetyDiscount;
    private double totalInsurance;

    public CalculateCarInsuranceResponse(double initialInsurancePerDay, double earlyReturnDiscount, double highSafetyDiscount, double totalInsurance) {
        this.initialInsurancePerDay = initialInsurancePerDay;


        this.earlyReturnDiscount = earlyReturnDiscount;
        this.highSafetyDiscount = highSafetyDiscount;
        this.totalInsurance = totalInsurance;
    }

    public double getInitialInsurancePerDay() {
        return initialInsurancePerDay;
    }

    public void setInitialInsurancePerDay(double initialInsurancePerDay) {
        this.initialInsurancePerDay = initialInsurancePerDay;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "initialInsurancePerDay=" + initialInsurancePerDay +
                ", earlyReturnDiscount=" + earlyReturnDiscount +
                ", highSafetyDiscount=" + highSafetyDiscount +
                ", totalInsurance=" + totalInsurance +
                '}';
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
