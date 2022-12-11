package com.food.order.system.order.service.domain;


import org.food.order.service.domain.entity.Customer;
import org.food.order.service.domain.entity.Order;
import org.food.order.service.domain.entity.Product;
import org.food.order.service.domain.entity.Restaurant;
import org.food.order.system.domain.valueobject.*;
import org.food.order.system.service.domain.dto.create.CreateOrderCommand;
import org.food.order.system.service.domain.dto.create.OrderAddress;
import org.food.order.system.service.domain.dto.create.OrderItem;
import org.food.order.system.service.domain.mapper.OrderDataMapper;
import org.food.order.system.service.domain.ports.input.service.OrderApplicationServiceInterface;
import org.food.order.system.service.domain.ports.output.repository.CustomerRepository;
import org.food.order.system.service.domain.ports.output.repository.OrderRepository;
import org.food.order.system.service.domain.ports.output.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = OrderTestConfiguration.class)
public class OrderApplicationTest {
    @Autowired
    private OrderApplicationServiceInterface orderApplicationService;
    @Autowired
    private OrderDataMapper orderDataMapper;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    private CreateOrderCommand createOrderCommand;
    private CreateOrderCommand createOrderCommandWrongPrice;
    private CreateOrderCommand createOrderCommandWrongProductPrice;
    private final UUID CUSTOMER_ID = UUID.fromString("");
    private final UUID RESTAURANT_ID = UUID.fromString("");
    private final UUID PRODUCT_ID = UUID.fromString("");
    private final UUID ORDER_ID = UUID.fromString("");
    private final BigDecimal PRICE = new BigDecimal("200.00");

    @BeforeAll
    public void init() {
        createOrderCommand = CreateOrderCommand.builder()
                .customerId(CUSTOMER_ID)
                .restaurantId(RESTAURANT_ID)
                .address(OrderAddress.builder().street("test street").postalCode("00123").city("testCity").build())
                .price(PRICE)
                .orderItems(
                        List.of(
                                OrderItem.builder().productId(PRODUCT_ID).quantity(1).price(new BigDecimal("50.00"))
                                        .subTotal(new BigDecimal("50.00")).build(),
                                OrderItem.builder().productId(PRODUCT_ID).quantity(1).price(new BigDecimal("50.00"))
                                        .subTotal(new BigDecimal("50.00")).build()
                        )
                )
                .build();

        createOrderCommandWrongPrice = CreateOrderCommand.builder()
                .customerId(CUSTOMER_ID)
                .restaurantId(RESTAURANT_ID)
                .address(OrderAddress.builder().street("test street").postalCode("00123").city("testCity").build())
                .price(new BigDecimal("250.00"))
                .orderItems(
                        List.of(
                                OrderItem.builder().productId(PRODUCT_ID).quantity(1).price(new BigDecimal("50.00"))
                                        .subTotal(new BigDecimal("50.00")).build(),
                                OrderItem.builder().productId(PRODUCT_ID).quantity(1).price(new BigDecimal("50.00"))
                                        .subTotal(new BigDecimal("150.00")).build()
                        )
                )
                .build();

        createOrderCommandWrongProductPrice = CreateOrderCommand.builder()
                .customerId(CUSTOMER_ID)
                .restaurantId(RESTAURANT_ID)
                .address(OrderAddress.builder().street("test street").postalCode("00123").city("testCity").build())
                .price(PRICE)
                .orderItems(
                        List.of(
                                OrderItem.builder().productId(PRODUCT_ID).quantity(1).price(new BigDecimal("50.00"))
                                        .subTotal(new BigDecimal("50.00")).build(),
                                OrderItem.builder().productId(PRODUCT_ID).quantity(1).price(new BigDecimal("50.00"))
                                        .subTotal(new BigDecimal("50.00")).build()
                        )
                )
                .build();

        Customer customer = new Customer();
        customer.setId(new CustomerId(CUSTOMER_ID));

        Restaurant restaurantResponse = Restaurant.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(List.of(new Product(new ProductId(PRODUCT_ID), "product-1", new Money(new BigDecimal("50.00")))
                , new Product(new ProductId(PRODUCT_ID), "product-2", new Money(new BigDecimal("50.00")))))
                .isActive(true)
                .build();

        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        order.setId(new OrderId(ORDER_ID));

        when(customerRepository.findCustomer(CUSTOMER_ID)).thenReturn(Optional.of(customer));
        when(restaurantRepository.findRestaurantInformation(orderDataMapper.createOrderCommandToRestaurant(createOrderCommand)))
                .thenReturn(Optional.of(restaurantResponse));
        when(orderRepository.save(any(Order.class))).thenReturn(order);
    }
}
