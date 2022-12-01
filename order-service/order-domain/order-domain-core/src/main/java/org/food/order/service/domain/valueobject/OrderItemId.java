package org.food.order.service.domain.valueobject;

import org.food.order.service.domain.entity.Product;
import org.food.order.system.domain.entity.BaseEntity;
import org.food.order.system.domain.valueobject.BaseId;
import org.food.order.system.domain.valueobject.OrderId;

import java.util.Objects;
import java.util.UUID;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
