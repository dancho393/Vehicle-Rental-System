package model.user;

import model.Invoice;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private int drivingExperience;
    private int age;
    private Set<Invoice> invoices = new HashSet<>();

    public User(String firstName, String lastName, String email, int drivingExperience, int age, Set<Invoice> invoices) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.drivingExperience = drivingExperience;
        this.age = age;
        this.invoices = invoices;
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

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }
}
