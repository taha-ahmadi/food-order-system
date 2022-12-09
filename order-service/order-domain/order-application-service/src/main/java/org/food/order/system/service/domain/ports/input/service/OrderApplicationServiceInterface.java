package org.food.order.system.service.domain.ports.input.service;

import jakarta.validation.Valid;
import org.food.order.system.service.domain.dto.create.CreateOrderCommand;
import org.food.order.system.service.domain.dto.create.CreateOrderResponse;
import org.food.order.system.service.domain.dto.track.TrackOrderQuery;
import org.food.order.system.service.domain.dto.track.TrackOrderResponse;

public interface OrderApplicationServiceInterface {

    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
