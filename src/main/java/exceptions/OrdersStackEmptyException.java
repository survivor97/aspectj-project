package exceptions;

public class OrdersStackEmptyException extends Exception {
    public OrdersStackEmptyException() {
        super("Order Stack Is Empty!");
    }
}
