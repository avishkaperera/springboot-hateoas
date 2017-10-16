# Spring Boot HATEOAS
HATEOAS stands for Hypermedia As The Engine Of Application State

It is one of the principles REST APIs are built upon.

In simple terms what this means is, 
>A REST API, when accessed will provide information to navigate the API dynamically by including hypermedia links 
to resources with the response.
 
This application explains how to implement a hypermedia driven REST API 

## Getting Started
* Import the project to your local development machine by executing `git clone https://github.com/avishkaperera/springboot-hateoas.git` on your terminal.
* Open the project using the IDE of your choice.
* Go to HateoasServiceApplication and run the app

> Since this a Spring Boot application with an embeded Tomcat server, you will not be needed to configure your own server.

### Database
A H2 in memory database was used to build this application since it does not deal with lot of data.
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

You need HATEOAS and JPA SpringBoot dependencies to get started with this application. JPA helps to communicate with the database and HATEOAS helps to create the hypermedia.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
```

This is the entry point to our SpringBoot application.
```java
@SpringBootApplication
public class HateoasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HateoasServiceApplication.class, args);
	}
}
```

Extending entity classes with `ResourceSupport` class gives the options to wrap the objects of this class as a resource and add hypermedia links to them
```java
public class Customer extends ResourceSupport {}
```

The controllers will be annotated with `@RestController` annotation to make them return JSON qualified data
```java
@RestController
public class CustomerController {}
```

### Endpoints
**Endpoint that returns all customers**
```java
public List<Customer> getAllCustomers() {
    List<Customer> customers = customerRepository.findAll();
    customers.forEach(c -> {
        c.add(linkTo(methodOn(CustomerController.class).getOneCustomer(c.getCustomerId())).withSelfRel());
    });
    return customers;
}
```

This line of code takes one customer resource and adds a hypermedia link to it to retrieve the details of that single customer. It creates a link that calls `getOneCustomer()` method on Customer Controller
```java
customers.forEach(c -> {
        c.add(linkTo(methodOn(CustomerController.class).getOneCustomer(c.getCustomerId())).withSelfRel());
    });
```

**Endpoint that returns a single customer**
```java
public Customer getOneCustomer(@PathVariable(value = "customerId") Integer customerId) {
        Customer customer = customerRepository.findOne(customerId);
        customer.add(linkTo(methodOn(CustomerController.class).getOneCustomer(customer.getCustomerId())).withSelfRel());
        if (customer.getOrderSet().size() > 0) {
            customer.add(linkTo(methodOn(CustomerController.class).getAllOrdersForCustomer(customer.getCustomerId())).withRel("allOrders"));
        }
        customer.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("all"));
        return customer;
    }
```

This code snippet checks if the customer has orders and if yes, will add a hypermedia link to retrieve the the orders of that specific customer
```java
if (customer.getOrderSet().size() > 0) {
            customer.add(linkTo(methodOn(CustomerController.class).getAllOrdersForCustomer(customer.getCustomerId())).withRel("allOrders"));
        }
```