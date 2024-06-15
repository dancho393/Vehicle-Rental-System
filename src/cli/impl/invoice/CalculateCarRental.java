package cli.impl.invoice;


import cli.command.invoice.calculate.rental.CalculateVehicleRentalCommand;
import cli.command.invoice.calculate.rental.CalculateVehicleRentalRequest;
import cli.command.invoice.calculate.rental.CalculateVehicleRentalResponse;

public class CalculateCarRental implements CalculateVehicleRentalCommand {
    @Override
    public CalculateVehicleRentalResponse execute(CalculateVehicleRentalRequest request) {
        double totalRentalPrice = calculateRentalPriceForDays(
                request.getDays(),
                request.getActualDays(),
                request.getVehicle().getShortPeriodRentalPrice(),
                request.getVehicle().getLongPeriodRentalPrice() );
        int daysWithHalfPrice= request.getDays()-request.getActualDays();
        return new CalculateVehicleRentalResponse(
                roundNumber(totalRentalPrice),
                daysWithHalfPrice,
                roundNumber(totalRentalPrice/request.getDays()));
    }
    private double calculateRentalPriceForDays(
            int days,
            int actualDays,
            double priceForShortPeriod,
            double priceForLongPeriod){
        double rentalPrice=0.0f;
        double currentPricePerDay;
        if(days<=7)
            currentPricePerDay = priceForShortPeriod;
        else
            currentPricePerDay = priceForLongPeriod;
        for(int i=0;i<actualDays;i++){
            rentalPrice+=currentPricePerDay;
        }
        int remainingDays=days-actualDays;
        for(int i=0;i<remainingDays;i++){
            rentalPrice+=currentPricePerDay/2;
        }
        return rentalPrice;
    }
    private double roundNumber(double number){
        return Math.round(number*100.0)/100.0;
    }
}
