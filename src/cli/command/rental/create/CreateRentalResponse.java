package cli.command.rental.create;

import cli.base.CommandResponse;

public class CreateRentalResponse implements CommandResponse {
    private String rental;
    private String message;

    public CreateRentalResponse(String rental, String message) {
        this.rental = rental;
        this.message = message;
    }

    @Override
    public String toString() {
        return
                "rental='" + rental + '\'' +
                ", message='" + message + '\'' ;
    }

    public String getRental() {
        return rental;
    }

    public void setRental(String rental) {
        this.rental = rental;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
