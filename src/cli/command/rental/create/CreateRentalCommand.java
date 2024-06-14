package cli.command.rental.create;

import cli.base.Command;

public interface CreateRentalCommand extends Command<CreateRentalRequest, CreateRentalResponse> {
    CreateRentalResponse execute(CreateRentalRequest request);
}
