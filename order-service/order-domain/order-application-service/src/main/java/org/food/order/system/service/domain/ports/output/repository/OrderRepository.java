package org.food.order.system.service.domain.ports.output.repository;


import org.food.order.service.domain.entity.Order;
import org.food.order.service.domain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findByTrackingId(TrackingId trackingId);
}
