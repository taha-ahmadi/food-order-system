package org.food.order.service.domain.entity;

import org.food.order.system.domain.entity.BaseEntity;
import org.food.order.system.domain.valueobject.Money;
import org.food.order.system.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {
    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    private String name;
    private Money price;

    public Product(ProductId productId, String name, Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }

    public void updateWithConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }
}
