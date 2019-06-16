package com.example.demo.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import lombok.extern.slf4j.Slf4j;

@RabbitListener(queues = "hello")
@Slf4j
public class RabbitConsumerListener {

	@RabbitHandler
	public void receive(String in) {
		log.info(" [x] Received '" + in + "'");
	}

}
