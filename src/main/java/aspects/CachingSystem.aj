package aspects;

import main.LogsManager;
import main.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public aspect CachingSystem {

    //Order caching for users
    private Map<String, List<Order>> orderListForUsers = new HashMap<>();

    pointcut createOrder() : call(* main.OrderManager.pushOrder(..));

    after() returning : createOrder() {
        Order order = (Order)thisJoinPoint.getArgs()[0];

        if(!orderListForUsers.containsKey(order.getUsername())) {
            orderListForUsers.put(order.getUsername(), new ArrayList<>());
        }

        orderListForUsers.get(order.getUsername()).add(order);
        LogsManager.info("Order caching system: New Order cached for: {" + order.getUsername() + "}; Orders map size for this user: " + orderListForUsers.get(order.getUsername()).size());
    }

    pointcut getOrders(String username) : call(List<Order> main.OrderManager.getHistoryOrdersForUsername(..)) && args(username);

    List<Order> around(String username) : getOrders(username) {
        if(orderListForUsers.containsKey(username)) {
            LogsManager.info("User order history for username {" + username + "} is returned from the aspect caching system.");
            return orderListForUsers.get(username);
        }
        LogsManager.info("User order history for username {" + username + "} is returned from the OrderManager class.");
        return proceed(username);
    }

//--------------------------------

}
