package org.food.order.system.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.food.order.system.domain.valueobject.OrderStatus;
import org.food.order.system.domain.valueobject.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class PaymentResponse {
    private final String id;
    private final String sagaId;
    private final String orderId;
    private final String paymentId;
    private final String customerId;
    private final BigDecimal price;
    private final Instant createdAt;
    private final PaymentStatus paymentStatus;
    private final List<String> failureMessages;
}
