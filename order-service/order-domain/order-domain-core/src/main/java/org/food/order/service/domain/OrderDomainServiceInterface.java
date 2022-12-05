package org.food.order.service.domain;

import org.food.order.service.domain.entity.Order;
import org.food.order.service.domain.entity.Restaurant;
import org.food.order.service.domain.event.OrderCancelledEvent;
import org.food.order.service.domain.event.OrderCreateEvent;
import org.food.order.service.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainServiceInterface {
    OrderCreateEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
