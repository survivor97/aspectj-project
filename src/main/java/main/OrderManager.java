package main;

import exceptions.OrdersStackEmptyException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class OrderManager {

    public static Deque<Order> orderStack = new ArrayDeque<>();

    public static List<Order> orderHistory = new ArrayList<>();

    public static void pushOrder(Order order) {
        orderStack.push(order);
        orderHistory.add(order);
    }

    public static Order popOrder() throws OrdersStackEmptyException {
        if(orderStack.peek() == null) {
            throw new OrdersStackEmptyException();
        }
        return orderStack.pop();
    }

    public static List<Order> getHistoryOrdersForUsername(String username) {
        List<Order> orderList = new ArrayList<>();

        for(int i=0; i < orderHistory.size(); i++) {
            if(orderHistory.get(i).getUsername().equals(username)) {
                orderList.add(orderHistory.get(i));
            }
        }

        return orderList;
    }

}