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

