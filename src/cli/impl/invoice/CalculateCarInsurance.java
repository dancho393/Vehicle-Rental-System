package cli.impl.invoice;


import cli.command.invoice.calculate.insurance.CalculateCarInsuranceCommand;
import cli.command.invoice.calculate.insurance.CalculateCarInsuranceRequest;
import cli.command.invoice.calculate.insurance.CalculateCarInsuranceResponse;


public class CalculateCarInsurance implements CalculateCarInsuranceCommand {
    @Override
    public CalculateCarInsuranceResponse execute(CalculateCarInsuranceRequest request) {

            double actualPricePerDay=calculateInsurancePerDay(
                    request.getCar().getInsurancePercentagePerDay(),
                    request.getCar().getValue());

            double actualPrice=calculateInsurancePrice(
                    request.getActualDays(),
                    request.getCar().getInsurancePercentagePerDay(),
                    request.getCar().getValue());
            double expectedPrice=calculateInsurancePrice(
                    request.getDays(),
                    request.getCar().getInsurancePercentagePerDay(),
                    request.getCar().getValue());

            double discountByEarlyReturn = expectedPrice - actualPrice;

            double discountForHighSafety=discountForHighRatingCars(request.getCar().getRating(),actualPrice);
            double totalPrice=actualPrice-discountByEarlyReturn-discountForHighSafety;
        return new CalculateCarInsuranceResponse(
            roundNumber(actualPricePerDay),
                roundNumber(discountByEarlyReturn),
                roundNumber(discountForHighSafety),
                roundNumber(totalPrice)

        );
    }
    public double roundNumber(double number){
        return Math.round(number*100.0)/100.0;
    }


    private double discountForHighRatingCars(int rating,double price) {
        return rating>=4?(price*0.1):(0.0f);
    }
    private double calculateInsurancePrice(int days,double insurancePercentagePerDay,double carValue){
        return days*calculateInsurancePerDay(insurancePercentagePerDay,carValue) ;
    }
    private double calculateInsurancePerDay(double insurancePercentagePerDay,double carValue){
        return (insurancePercentagePerDay*insurancePercentagePerDay)*carValue;
    }

}
