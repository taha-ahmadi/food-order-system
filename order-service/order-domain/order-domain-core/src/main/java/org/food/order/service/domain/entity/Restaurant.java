package org.food.order.service.domain.entity;

import org.food.order.system.domain.entity.AggregateRoot;
import org.food.order.system.domain.valueobject.RestaurantId;

import java.util.List;

public class Restaurant extends AggregateRoot<RestaurantId> {
    private final List<Product> products;
    private boolean isActive;

    private Restaurant(Builder builder) {
        super.setId(builder.restaurantId);
        products = builder.products;
        isActive = builder.isActive;
    }


    public static final class Builder {
        private RestaurantId restaurantId;
        private List<Product> products;
        private boolean isActive;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder restaurantId(RestaurantId val) {
            restaurantId = val;
            return this;
        }

        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        public Builder isActive(boolean val) {
            isActive = val;
            return this;
        }

        public Restaurant build() {
            return new Restaurant(this);
        }
    }
}
