package cli.command.user.create;

import cli.base.Command;

public interface CreateUserCommand extends Command<CreateUserRequest, CreateUserResponse> {
        CreateUserResponse execute(CreateUserRequest request);
}
