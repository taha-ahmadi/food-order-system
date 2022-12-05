package org.food.order.system.service.domain.dto.track;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.food.order.system.domain.valueobject.OrderStatus;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class TrackOrderResponse {
    @NonNull
    private final UUID orderTrackingId;
    @NonNull
    private final OrderStatus orderStatus;
    private final List<String> failureMessages;
}
