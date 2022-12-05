package org.food.order.system.service.domain.dto.track;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.food.order.system.service.domain.dto.create.OrderAddress;
import org.food.order.system.service.domain.dto.create.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class TrackOrderQuery {
    @NonNull
    private final UUID orderTrackingId;
}
