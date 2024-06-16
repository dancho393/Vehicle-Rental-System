package cli.impl.invoice;

import cli.command.invoice.calculate.van.insurance.CalculateVanInsuranceCommand;
import cli.command.invoice.calculate.van.insurance.CalculateVanInsuranceRequest;
import cli.command.invoice.calculate.van.insurance.CalculateVanInsuranceResponse;
import model.user.LoggedUser;

public class CalculateVanInsurance implements CalculateVanInsuranceCommand {
    @Override
    public CalculateVanInsuranceResponse execute(CalculateVanInsuranceRequest request) {
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
        double priceWithExperiencePerDay=discountForExperience(initialInsurancePerDay);

        double discountForEarlyReturn=expectedInsurancePrice-initialInsurancePrice;

        double actualInsurancePrice = (priceWithExperiencePerDay * request.getActualDays());

        return new CalculateVanInsuranceResponse(
                roundNumber(initialInsurancePerDay),
                roundNumber(initialInsurancePrice),
                roundNumber(expectedInsurancePrice),
                roundNumber(priceWithExperiencePerDay),
                roundNumber(discountForEarlyReturn),
                roundNumber(discountForEarlyReturn/request.getActualDays()),
                roundNumber(discountForExperience(discountForExperience(initialInsurancePerDay)/request.getActualDays())),
                roundNumber(discountForExperience(initialInsurancePerDay)),
                roundNumber(priceWithExperiencePerDay),
                roundNumber(actualInsurancePrice)

        );
    }
    private double discountForExperience(double price){
        return LoggedUser.getInstance().getUser().getDrivingExperience()>5?(price/100*85):price;//15%
    }
    private double roundNumber(double number){
        return Math.round(number*100.0)/100.0;
    }
    private double calculateInsurancePrice(int days,double insurancePercentagePerDay,double carValue){
        return days*calculateInsurancePerDay(insurancePercentagePerDay,carValue) ;
    }
    private double calculateInsurancePerDay(double insurancePercentagePerDay,double carValue){
        return (insurancePercentagePerDay*(carValue/100));
    }
}
