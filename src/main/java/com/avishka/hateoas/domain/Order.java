package com.avishka.hateoas.domain;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created by Avishka-Perera on 9/15/2017.
 */
@Entity
@Table(name = "ORDERS")
public class Order extends ResourceSupport {
    @Id
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public Order() {
    }

    public Order(Integer orderId, Integer price, Integer quantity, Customer customer) {
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
        this.customer = customer;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", price=" + price +
                ", quantity=" + quantity +
                ", customer=" + customer +
                '}';
    }
}
