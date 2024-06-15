package cli.command.invoice.calculate.motorcycle.rental;

import cli.base.Command;

public interface CalculateMotorcycleRentalCommand extends Command<CalculateMotorcycleRentalRequest,CalculateMotorcycleRentalResponse> {

    CalculateMotorcycleRentalResponse execute(CalculateMotorcycleRentalRequest request);
}
