package com.avishka.hateoas.repositories;

import com.avishka.hateoas.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Avishka-Perera on 9/15/2017.
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
