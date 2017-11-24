package com.hikex.publisher;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

import com.hikex.product_schema.Product;

@SpringBootApplication
public class SpringBootActivemqPublisherApplication implements
		CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActivemqPublisherApplication.class,
				args);
	}

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${outbound.endpoint}")
	private String destination;

	@Override
	public void run(String... args) throws Exception {
		Product product = new Product();
		product.setProductId(UUID.randomUUID().toString());
		product.setProductName("PUMA-Round_Neck_Tshirt");

		jmsTemplate.convertAndSend(destination, product);

	}
}
