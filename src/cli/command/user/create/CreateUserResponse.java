package cli.command.user.create;

import cli.base.CommandResponse;

public class CreateUserResponse implements CommandResponse {
    private String message;

    public CreateUserResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
