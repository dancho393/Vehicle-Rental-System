package config;

import cli.command.user.create.CreateUserCommand;
import cli.command.user.create.CreateUserRequest;
import cli.impl.user.CreateUser;

public class StartUpData {
    public StartUpData() {
    }
    public void run() {
        createUser();
    }
    private void createUser() {
        CreateUserRequest request = new CreateUserRequest(
                "Yordan",
                "Yordanov",
                "danez7000@gmail.com",
                3,
                22);
        CreateUserCommand command = new CreateUser();
        System.out.println(command.execute(request).getMessage());
    }
}
