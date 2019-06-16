package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableConfigServer
@Slf4j
public class DemoConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigServerApplication.class, args);
		log.info("Demo config server --> Able to start");
	}

}
