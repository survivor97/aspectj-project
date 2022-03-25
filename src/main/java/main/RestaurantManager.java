package main;

public class RestaurantManager extends Account {

    public RestaurantManager(String firstName, String lastName, String email, String username, String password) {
        super(firstName, lastName, email, username, password);
        this.role = Role.RESTAURANT_MANAGER;
    }

}
