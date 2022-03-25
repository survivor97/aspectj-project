package main;

public class Admin extends Account {

    public Admin(String firstName, String lastName, String email, String username, String password) {
        super(firstName, lastName, email, username, password);
        this.role = Role.ADMIN;
    }

}
