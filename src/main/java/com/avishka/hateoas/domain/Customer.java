package com.avishka.hateoas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Avishka-Perera on 9/15/2017.
 */
@Component
@Entity
@Table(name = "CUSTOMERS")
public class Customer extends ResourceSupport {

    @Id
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Order> orderSet;

    public Customer() {
    }

    public Customer(Integer customerId, String customerName, List<Order> orderSet) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderSet = orderSet;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(List<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", orderSet=" + orderSet +
                '}';
    }
}
