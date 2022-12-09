package org.food.order.system.service.domain.ports.output.repository;


import org.food.order.service.domain.entity.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findCustomer(Customer customer);
}
