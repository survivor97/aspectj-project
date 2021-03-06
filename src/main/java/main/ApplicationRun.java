package main;

import exceptions.OrdersStackEmptyException;

import java.util.ArrayList;

public class ApplicationRun {

    public static void main(String[] args) throws OrdersStackEmptyException {
        //--------------------------------------------------------------------
        Order order = new Order("me","res", new ArrayList<>());
        System.out.println(order.getOrderDateTime());
        
        Food food1 = new Food("pizza",8,10);
        System.out.println("With price " + food1.getPrice());
        FoodManager.popFood();

        OrderManager.popOrder();
        OrderManager.pushOrder(new Order("abc", "res", new ArrayList<>()));
        OrderManager.popOrder();

        Restaurant restaurant = new Restaurant("Abc0");
        Restaurant restaurant2 = new Restaurant("Restaurant Unu");

        Account adminAccount = new Admin("Admin", "Admin", "admin.account@admin.com", "admin", "password1");
        System.out.println("Account check: " + adminAccount);

        User user = new User("Alex", "Kover", "alex.kover@yahoo.com", "alex.kover", "qwerty1");
        System.out.println("User account: " + user);

        OrderManager.pushOrder(new Order("alex.kover", "Restaurant Unu", new ArrayList<>()));
        OrderManager.pushOrder(new Order("alex.kover", "Restaurant Unu", new ArrayList<>()));

        System.out.println("Order history for alex.kover: " + OrderManager.getHistoryOrdersForUsername("alex.kover"));

        Food food = new Food("Pezza", 100, 300);
        food.setName("Pizza");
        //--------------------------------------------------------------------

        adminAccount.setEmail("other.admin@admin.com");
        adminAccount.setPassword("password123$");
        System.out.println(adminAccount.getPassword());
        adminAccount.setPassword("dfgd123$");
        System.out.println(adminAccount.getPassword());
        OrderManager.expensiveComputation();
        adminAccount.setEmail("alexkoverahoo.com");
        adminAccount.setEmail("alex.kover@yahoo.com");
        adminAccount.setEmail("alex.kover97@yahoo.com");

    }

}
