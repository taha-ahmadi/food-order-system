package org.food.order.system.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.food.order.system.service.domain.dto.create.CreateOrderCommand;
import org.food.order.system.service.domain.dto.create.CreateOrderResponse;
import org.food.order.system.service.domain.dto.track.TrackOrderQuery;
import org.food.order.system.service.domain.dto.track.TrackOrderResponse;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderTrackCommandHandler {
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return null;
    }
}
