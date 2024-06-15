package cli.command.invoice.calculate.car.rental;

import cli.base.Command;

public interface CalculateCarRentalCommand extends Command<CalculateCarRentalRequest,CalculateCarRentalResponse> {
    @Override
    CalculateCarRentalResponse execute(CalculateCarRentalRequest request);
}
