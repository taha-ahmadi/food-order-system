package org.food.order.system.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class OrderItem {
    @NonNull
    private final UUID productId;
    @NonNull
    private final Integer quantity;
    @NonNull
    private final BigDecimal price;
    @NonNull
    private final BigDecimal subTotal;
}
