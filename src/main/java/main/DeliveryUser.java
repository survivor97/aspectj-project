package main;

public class DeliveryUser extends Account {

    public DeliveryUser(String firstName, String lastName, String email, String username, String password) {
        super(firstName, lastName, email, username, password);
        this.role = Role.DELIVERY_USER;
    }

}
