package org.food.order.system.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.food.order.system.service.domain.dto.create.CreateOrderCommand;
import org.food.order.system.service.domain.dto.create.CreateOrderResponse;
import org.food.order.system.service.domain.dto.track.TrackOrderQuery;
import org.food.order.system.service.domain.dto.track.TrackOrderResponse;
import org.food.order.system.service.domain.ports.input.service.OrderApplicationServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class OrderApplicationService implements OrderApplicationServiceInterface {

    private final OrderCreateCommandHandler orderCreateCommandHandler;
    private final OrderTrackCommandHandler orderTrackCommandHandler;

    OrderApplicationService(OrderCreateCommandHandler orderCreateCommandHandler, OrderTrackCommandHandler orderTrackCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
        this.orderTrackCommandHandler = orderTrackCommandHandler;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return orderTrackCommandHandler.trackOrder(trackOrderQuery);
    }
}
