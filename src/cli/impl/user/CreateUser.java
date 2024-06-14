package cli.impl.user;

import cli.command.user.create.CreateUserCommand;
import cli.command.user.create.CreateUserRequest;
import cli.command.user.create.CreateUserResponse;
import model.user.LoggedUser;
import model.user.User;

import java.util.HashSet;

public class CreateUser implements CreateUserCommand {
    @Override
    public CreateUserResponse execute(CreateUserRequest request) {
        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getDrivingExperience(),
                request.getAge(),
                new HashSet<>());
        LoggedUser.getInstance().setUser(user);

        return new CreateUserResponse("User Created And Logged");
    }
}
