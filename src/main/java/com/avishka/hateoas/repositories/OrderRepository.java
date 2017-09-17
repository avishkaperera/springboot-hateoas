package com.avishka.hateoas.repositories;

import com.avishka.hateoas.domain.Customer;
import com.avishka.hateoas.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Avishka-Perera on 9/15/2017.
 */
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByCustomer(Customer customer);
}
