package org.food.order.service.domain.entity;

import org.food.order.service.domain.valueobject.OrderItemId;
import org.food.order.system.domain.entity.BaseEntity;
import org.food.order.system.domain.valueobject.Money;
import org.food.order.system.domain.valueobject.OrderId;

public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;
    private final Product product;
    private final Money price;
    private final Money subTotal;
    private final int quantity;

    private OrderItem(Builder builder) {
        super.setId(builder.orderItemId);
        product = builder.product;
        price = builder.price;
        subTotal = builder.subTotal;
        quantity = builder.quantity;
    }


    public OrderId getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
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

    void initializeOrderItem(OrderId orderId, OrderItemId orderItemId) {
        this.orderId = orderId;
        super.setId(orderItemId);
    }

    boolean isPriceValid(){
        return price.isGreaterThanZero() && price.equals(product.getPrice())
                && price.multiply(quantity).equals(subTotal);
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
