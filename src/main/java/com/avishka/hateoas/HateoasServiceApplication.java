package com.avishka.hateoas;

import com.avishka.hateoas.domain.Customer;
import com.avishka.hateoas.domain.Order;
import com.avishka.hateoas.repositories.CustomerRepository;
import com.avishka.hateoas.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@SpringBootApplication
public class HateoasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HateoasServiceApplication.class, args);
	}
}
