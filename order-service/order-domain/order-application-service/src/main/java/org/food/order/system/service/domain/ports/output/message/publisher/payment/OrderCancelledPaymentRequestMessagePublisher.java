package org.food.order.system.service.domain.ports.output.message.publisher.payment;

import org.food.order.service.domain.event.OrderCancelledEvent;
import org.food.order.system.domain.event.publisher.DomainEventPublisher;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
