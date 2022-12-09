package org.food.order.system.service.domain.ports.output.message.publisher.restaurant_approval;


import org.food.order.service.domain.event.OrderPaidEvent;
import org.food.order.system.domain.event.publisher.DomainEventPublisher;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
