package cli.command.invoice.calculate.rental;

import cli.base.Command;

public interface CalculateVehicleRentalCommand extends Command<CalculateVehicleRentalRequest, CalculateVehicleRentalResponse> {
    @Override
    CalculateVehicleRentalResponse execute(CalculateVehicleRentalRequest request);
}
