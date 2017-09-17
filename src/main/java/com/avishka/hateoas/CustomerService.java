package com.avishka.hateoas;

import com.avishka.hateoas.domain.Customer;
import com.avishka.hateoas.domain.Order;
import com.avishka.hateoas.repositories.CustomerRepository;
import com.avishka.hateoas.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Avishka-Perera on 9/17/2017.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findOrdersByCustomerId(Integer customerId){
        Customer customer = customerRepository.findOne(customerId);
        return orderRepository.findByCustomer(customer);
    }
}
