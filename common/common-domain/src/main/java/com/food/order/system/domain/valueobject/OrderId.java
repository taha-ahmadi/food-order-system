package com.food.order.system.domain.valueobject;

import java.util.UUID;

public class OrderId extends BaseId<UUID>{
    protected OrderId(UUID value) {
        super(value);
    }
}
