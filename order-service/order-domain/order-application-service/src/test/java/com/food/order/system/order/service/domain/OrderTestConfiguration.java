package com.food.order.system.order.service.domain;

import org.food.order.service.domain.OrderDomainService;
import org.food.order.service.domain.OrderDomainServiceInterface;
import org.food.order.system.service.domain.ports.output.message.publisher.payment.OrderCancelledPaymentRequestMessagePublisher;
import org.food.order.system.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import org.food.order.system.service.domain.ports.output.message.publisher.restaurant_approval.OrderPaidRestaurantRequestMessagePublisher;
import org.food.order.system.service.domain.ports.output.repository.CustomerRepository;
import org.food.order.system.service.domain.ports.output.repository.OrderRepository;
import org.food.order.system.service.domain.ports.output.repository.RestaurantRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.food.order.system")
public class OrderTestConfiguration {
    @Bean
    public OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher(){
        return Mockito.mock(OrderCreatedPaymentRequestMessagePublisher.class);
    }

    @Bean
    public OrderCancelledPaymentRequestMessagePublisher orderCancelledPaymentRequestMessagePublisher(){
        return Mockito.mock(OrderCancelledPaymentRequestMessagePublisher.class);
    }

    @Bean
    public OrderPaidRestaurantRequestMessagePublisher orderPaidRestaurantRequestMessagePublisher(){
        return Mockito.mock(OrderPaidRestaurantRequestMessagePublisher.class);
    }

    @Bean
    public OrderRepository orderRepository(){
        return Mockito.mock(OrderRepository.class);
    }

    @Bean
    public CustomerRepository customerRepository(){
        return Mockito.mock(CustomerRepository.class);
    }

    @Bean
    public RestaurantRepository restaurantRepository(){
        return Mockito.mock(RestaurantRepository.class);
    }

    @Bean
    public OrderDomainServiceInterface orderDomainService(){
        return new OrderDomainService();
    }
}
