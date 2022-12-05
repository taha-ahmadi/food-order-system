package org.food.order.service.domain.event;

import org.food.order.service.domain.entity.Order;
import org.food.order.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public class OrderCreateEvent extends OrderEvent{

    public OrderCreateEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
