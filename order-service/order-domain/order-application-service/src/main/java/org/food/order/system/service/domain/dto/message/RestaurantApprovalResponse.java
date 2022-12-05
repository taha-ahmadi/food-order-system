package org.food.order.system.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.food.order.system.domain.valueobject.OrderApprovalStatus;
import org.food.order.system.domain.valueobject.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class RestaurantApprovalResponse {
    private final String id;
    private final String sagaId;
    private final String orderId;
    private final String restaurantId;
    private final Instant createdAt;
    private final OrderApprovalStatus paymentStatus;
    private final List<String> failureMessages;
}
