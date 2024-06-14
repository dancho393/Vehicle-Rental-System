package cli.command.user.create;

import cli.base.CommandRequest;

public class CreateUserRequest implements CommandRequest {
    private String firstName;
    private String lastName;
    private String email;
    private int drivingExperience;
    private int age;

    public CreateUserRequest(String firstName, String lastName, String email, int drivingExperience, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.drivingExperience = drivingExperience;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
