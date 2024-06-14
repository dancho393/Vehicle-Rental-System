package cli.command.rental.create;

import cli.base.CommandResponse;
import model.base.Rental;

public class CreateRentalResponse implements CommandResponse {
    private Rental rental;
    private String message;

    @Override
    public String toString() {
        return "CreateRentalResponse{" +
                "rental=" + rental.toString() +
                ", message='" + message + '\'' +
                '}';
    }

    public CreateRentalResponse(Rental rental, String message) {
        this.rental = rental;
        this.message = message;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
