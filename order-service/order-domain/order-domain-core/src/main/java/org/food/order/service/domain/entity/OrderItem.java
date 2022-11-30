package org.food.order.service.domain.entity;

import org.food.order.service.domain.valueobject.OrderItemId;
import org.food.order.service.domain.valueobject.StreetAddress;
import org.food.order.system.domain.entity.AggregateRoot;
import org.food.order.system.domain.entity.BaseEntity;
import org.food.order.system.domain.valueobject.CustomerId;
import org.food.order.system.domain.valueobject.Money;
import org.food.order.system.domain.valueobject.OrderId;
import org.food.order.system.domain.valueobject.RestaurantId;

import java.util.List;

public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;
    private final Product poduct;
    private final Money price;
    private final Money subTotal;
    private final int quantity;

    private OrderItem(Builder builder) {
        super.setId(builder.orderItemId);
        poduct = builder.product;
        price = builder.price;
        subTotal = builder.subTotal;
        quantity = builder.quantity;
    }


    public OrderId getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return poduct;
    }

    public Money getPrice() {
        return price;
    }

    public Money getSubTotal() {
        return subTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public static final class Builder {
        private OrderItemId orderItemId;
        private Product product;
        private Money price;
        private Money subTotal;
        private int quantity;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder orderItemId(OrderItemId val) {
            orderItemId = val;
            return this;
        }

        public Builder product(Product val) {
            product = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder subTotal(Money val) {
            subTotal = val;
            return this;
        }

        public Builder quantity(int val) {
            quantity = val;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
