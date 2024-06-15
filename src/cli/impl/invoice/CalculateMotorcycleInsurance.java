package cli.impl.invoice;

import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceCommand;
import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceRequest;
import cli.command.invoice.calculate.motorcycle.insurance.CalculateMotorcycleInsuranceResponse;

public class CalculateMotorcycleInsurance implements CalculateMotorcycleInsuranceCommand {
    @Override
    public CalculateMotorcycleInsuranceResponse execute(CalculateMotorcycleInsuranceRequest request) {
        double initialInsurancePerDay = calculateInsurancePerDay(
                request.getVehicle().getInsurancePercentagePerDay(),
                request.getVehicle().getValue());

        double initialInsurancePrice=calculateInsurancePrice(
                request.getActualDays(),
                request.getVehicle().getInsurancePercentagePerDay(),
                request.getVehicle().getValue());

        double expectedInsurancePrice=calculateInsurancePrice(
                request.getDays(),
                request.getVehicle().getInsurancePercentagePerDay(),
                request.getVehicle().getValue());
        double lowAgeInsurancePricePerDay=extraPriceForLowAge(initialInsurancePerDay);

        double discountForEarlyReturn=expectedInsurancePrice-initialInsurancePrice;

        double actualInsurancePricePerDay=initialInsurancePerDay+lowAgeInsurancePricePerDay;

        double actualInsurancePrice = (actualInsurancePricePerDay* request.getActualDays())-discountForEarlyReturn;


        return new CalculateMotorcycleInsuranceResponse(
                initialInsurancePerDay,
                initialInsurancePrice,
                expectedInsurancePrice,
                lowAgeInsurancePricePerDay,
                discountForEarlyReturn,
                actualInsurancePricePerDay,
                actualInsurancePrice
        );
    }
    private double roundNumber(double number){
        return Math.round(number*100.0)/100.0;
    }

    private double calculateInsurancePrice(int days,double insurancePercentagePerDay,double motorcycleValue){
        return days*calculateInsurancePerDay(insurancePercentagePerDay,motorcycleValue) ;
    }
    private double calculateInsurancePerDay(double insurancePercentagePerDay,double motorcycleValue){
        return (motorcycleValue/100)*insurancePercentagePerDay;
    }
    private double extraPriceForLowAge(double insurancePerDay){
        return insurancePerDay/5;

    }


}
