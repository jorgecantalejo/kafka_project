package com.kafka.controller;

import com.kafka.productor.MessageProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	private MessageProducer messageProducer;

	@PostMapping("/msg")
	public String sendMessage(@RequestParam("message") String message, @RequestParam("topic") String topic) {
		messageProducer.sendMessage(message, topic);
		return "Mensaje enviado";
	}
}
