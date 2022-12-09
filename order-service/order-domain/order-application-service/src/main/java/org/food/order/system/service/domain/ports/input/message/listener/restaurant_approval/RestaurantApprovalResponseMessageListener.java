package org.food.order.system.service.domain.ports.input.message.listener.restaurant_approval;

import org.food.order.system.service.domain.dto.message.RestaurantApprovalResponse;

public interface RestaurantApprovalResponseMessageListener {
    void orderApproved(RestaurantApprovalResponse paymentResponse);

    void orderRejected(RestaurantApprovalResponse paymentResponse);

}
