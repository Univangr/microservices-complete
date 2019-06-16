package com.example.demo.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RabbitPublisherController {
	
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;
	
    @RequestMapping(value="/publisher", method=RequestMethod.GET)
    public String publisher(@RequestParam(value="message", defaultValue="Hello World Rabbit") String message){
    	
    	log.debug("quiero ver esto message: "+message);
    	
    	template.convertAndSend(queue.getName(),message);

        return "message: "+ message;
    }

}
