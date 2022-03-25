package main;

public class User extends Account {

    public User(String firstName, String lastName, String email, String username, String password) {
        super(firstName, lastName, email, username, password);
        this.role = Role.USER;
    }

}
