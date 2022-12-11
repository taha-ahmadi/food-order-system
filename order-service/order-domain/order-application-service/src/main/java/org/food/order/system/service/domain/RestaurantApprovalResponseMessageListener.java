package org.food.order.system.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.food.order.system.service.domain.dto.message.RestaurantApprovalResponse;
import org.food.order.system.service.domain.ports.input.message.listener.restaurant_approval.RestaurantApprovalResponseMessageListenerInterface;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class RestaurantApprovalResponseMessageListener implements RestaurantApprovalResponseMessageListenerInterface {

    @Override
    public void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse) {

    }

    @Override
    public void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse) {

    }
}
