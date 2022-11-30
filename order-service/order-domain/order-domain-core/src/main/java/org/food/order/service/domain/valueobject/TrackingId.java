package org.food.order.service.domain.valueobject;

import org.food.order.system.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {

    protected TrackingId(UUID value) {
        super(value);
    }
}
