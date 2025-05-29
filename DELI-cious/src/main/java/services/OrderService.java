package services;

import models.Order;

public interface OrderService {
    Order createOrder();
    void addSandwich(Order order);
    void addDrink(Order order);
    void addChips(Order order);
    void checkout(Order order);
    void cancelOrder(Order order);
}
