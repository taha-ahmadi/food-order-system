package org.food.order.system.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.food.order.service.domain.entity.Order;
import org.food.order.service.domain.exception.OrderNotFoundException;
import org.food.order.service.domain.valueobject.TrackingId;
import org.food.order.system.service.domain.dto.track.TrackOrderQuery;
import org.food.order.system.service.domain.dto.track.TrackOrderResponse;
import org.food.order.system.service.domain.mapper.OrderDataMapper;
import org.food.order.system.service.domain.ports.output.repository.OrderRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class OrderTrackCommandHandler {
    private final OrderDataMapper orderDataMapper;
    private final OrderRepository orderRepository;

    public OrderTrackCommandHandler(OrderDataMapper orderDataMapper, OrderRepository orderRepository) {
        this.orderDataMapper = orderDataMapper;
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        Optional<Order> order = orderRepository.findByTrackingId(new TrackingId(trackOrderQuery.getOrderTrackingId()));
        if(order.isEmpty()){
            log.warn("Could not find order wih tracking id: {}", trackOrderQuery.getOrderTrackingId());
            throw new OrderNotFoundException("Could not find order wih tracking id: " + trackOrderQuery.getOrderTrackingId());
        }
        return orderDataMapper.orderToTrackOrderResponse(order.get());
    }
}
