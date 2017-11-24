package com.hikex.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

import com.hikex.product_schema.Product;

@SpringBootApplication
public class SpringBootActivemqConsumerApplication {

	private static final Logger log = LoggerFactory
			.getLogger(SpringBootActivemqConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication
				.run(SpringBootActivemqConsumerApplication.class, args);
	}

	@JmsListener(destination = "${inbound.endpoint}")
	public void process(Product product) {
		log.info("product", product);
	}
}
