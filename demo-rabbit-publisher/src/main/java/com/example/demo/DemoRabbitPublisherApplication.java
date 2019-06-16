package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoRabbitPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRabbitPublisherApplication.class, args);
		log.info("Application able to start");
	}

}
