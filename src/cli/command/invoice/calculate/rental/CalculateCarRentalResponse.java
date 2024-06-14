package cli.command.invoice.calculate.rental;

import cli.base.CommandResponse;

public class CalculateCarRentalResponse implements CommandResponse {
    private double rentalPrice;
    private int daysWithHalfPrice;
    private double pricePerDay;

    public CalculateCarRentalResponse(double rentalPrice, int daysWithHalfPrice, double pricePerDay) {
        this.rentalPrice = rentalPrice;
        this.daysWithHalfPrice = daysWithHalfPrice;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rentalPrice=" + rentalPrice +
                ", daysWithHalfPrice=" + daysWithHalfPrice +
                ", pricePerDay=" + pricePerDay +
                '}';
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getDaysWithHalfPrice() {
        return daysWithHalfPrice;
    }

    public void setDaysWithHalfPrice(int daysWithHalfPrice) {
        this.daysWithHalfPrice = daysWithHalfPrice;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
