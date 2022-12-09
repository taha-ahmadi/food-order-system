package org.food.order.system.service.domain.ports.output.repository;


import org.food.order.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findCustomer(UUID customer);
}
