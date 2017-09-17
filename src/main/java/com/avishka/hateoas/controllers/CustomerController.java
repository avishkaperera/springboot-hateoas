package com.avishka.hateoas.controllers;

import com.avishka.hateoas.CustomerService;
import com.avishka.hateoas.domain.Customer;
import com.avishka.hateoas.domain.Order;
import com.avishka.hateoas.repositories.CustomerRepository;
import com.avishka.hateoas.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Avishka-Perera on 9/17/2017.
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        customers.forEach(c -> {
            c.add(linkTo(methodOn(CustomerController.class).getOneCustomer(c.getCustomerId())).withSelfRel());
        });
        return customers;
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getOneCustomer(@PathVariable(value = "customerId") Integer customerId) {
        Customer customer = customerRepository.findOne(customerId);
        customer.add(linkTo(methodOn(CustomerController.class).getOneCustomer(customer.getCustomerId())).withSelfRel());
        if (customer.getOrderSet().size() > 0) {
            customer.add(linkTo(methodOn(CustomerController.class).getAllOrdersForCustomer(customer.getCustomerId())).withRel("allOrders"));
        }
        customer.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("all"));
        return customer;
    }

    @RequestMapping(value = "/{customerId}/orders", method = RequestMethod.GET)
    public List<Order> getAllOrdersForCustomer(@PathVariable(value = "customerId") Integer customerId) {
        return customerService.findOrdersByCustomerId(customerId);
    }
}
