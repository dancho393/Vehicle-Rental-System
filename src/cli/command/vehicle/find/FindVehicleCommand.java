package cli.command.vehicle.find;

import cli.base.Command;

public interface FindVehicleCommand extends Command<FindVehicleRequest,FindVehicleResponse> {
    FindVehicleResponse execute(FindVehicleRequest request);
}
