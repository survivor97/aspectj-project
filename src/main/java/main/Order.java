package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {

    private String username;
    private String restaurantName;
    private List<Food> foodList;
    private Date orderDateTime;

    public Order(String username, String restaurantName, List<Food> foodList) {
        this.username = username;
        this.restaurantName = restaurantName;
        this.foodList = foodList;
        orderDateTime = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "Order{" +
                "username='" + username + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", foodList=" + foodList +
                ", orderDateTime=" + orderDateTime +
                '}';
    }

    public String getOrderDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        return formatter.format(orderDateTime);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void setOrderDateTime(Date orderDateTime) {
        this.orderDateTime = orderDateTime;
    }
}
