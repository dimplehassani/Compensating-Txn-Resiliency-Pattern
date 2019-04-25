package com.productdescription.ProductCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCartApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() { 
		return new RestTemplate(); }
}
