package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.ExampleSender;

@Configuration
public class RabbitConfig {

	@Bean
	public Queue hello() {
		return new Queue("hello");
	}

	@Bean
	public ExampleSender sender() {
		return new ExampleSender();
	}

}
