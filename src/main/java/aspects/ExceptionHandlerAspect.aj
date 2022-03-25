package aspects;

import exceptions.OrdersStackEmptyException;
import main.LogsManager;

public aspect ExceptionHandlerAspect {

    pointcut ordersStack() : call(* main.OrderManager.popOrder());

    Object around() throws OrdersStackEmptyException: ordersStack() {
        try {
            return  proceed();
        } catch (Exception exception) {
            LogsManager.exception(exception);
            return null;
        }
    }

}
