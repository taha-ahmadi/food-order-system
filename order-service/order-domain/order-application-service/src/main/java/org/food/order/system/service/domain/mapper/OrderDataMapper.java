package org.food.order.system.service.domain.mapper;


import org.food.order.service.domain.entity.Order;
import org.food.order.service.domain.entity.OrderItem;
import org.food.order.service.domain.entity.Product;
import org.food.order.service.domain.entity.Restaurant;
import org.food.order.service.domain.valueobject.StreetAddress;
import org.food.order.service.domain.valueobject.TrackingId;
import org.food.order.system.domain.valueobject.CustomerId;
import org.food.order.system.domain.valueobject.Money;
import org.food.order.system.domain.valueobject.ProductId;
import org.food.order.system.domain.valueobject.RestaurantId;
import org.food.order.system.service.domain.dto.create.CreateOrderCommand;
import org.food.order.system.service.domain.dto.create.CreateOrderResponse;
import org.food.order.system.service.domain.dto.create.OrderAddress;
import org.food.order.system.service.domain.dto.track.TrackOrderResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {
    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand) {
        return Restaurant.builder().restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getOrderItems().stream().map(orderItem -> new Product(new ProductId(orderItem.getProductId()))
                        ).collect(Collectors.toList())
                )
                .build();
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getOrderItems()))
                .build();
    }

    public TrackOrderResponse orderToTrackOrderResponse(Order order){
        return TrackOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .failureMessages(order.getFailureMessages())
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message){
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .messages(message)
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(List<org.food.order.system.service.domain.dto.create.OrderItem> orderItems) {
        return orderItems.stream().map(
                orderItem -> OrderItem.builder()
                        .product(new Product(new ProductId(orderItem.getProductId())))
                        .price(new Money(orderItem.getPrice()))
                        .quantity(orderItem.getQuantity())
                        .subTotal(new Money(orderItem.getSubTotal()))
                        .build()
        ).collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress address) {
        return new StreetAddress(
                UUID.randomUUID(),
                address.getStreet(),
                address.getPostalCode(),
                address.getCity()
        );
    }
}
