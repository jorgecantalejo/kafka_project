package com.kafka.consumer;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
public class MessageConsumer {

	@KafkaListener(topics = "topic1", groupId = "group0")
	public void listenTopic1(String message) {
		System.out.println("Received Messasge in group 0 - topic 1: " + message);
	}

	@KafkaListener(topics = "topic2", groupId = "group0")
	public void listenTopic2(String message) {
		System.out.println("Received Messasge in group 0 - topic 2: " + message);
	}

	@KafkaListener(topics = "topic3", groupId = "group0")
	public void listenTopic3(String message) {
		System.out.println("Received Messasge in group 0 - topic 3: " + message);
	}

	@KafkaListener(topics = "topic1, topic2, topic3", groupId = "group0")
	public void listenTopicAll(String message) {
		System.out.println("Received Messasge in group 0 - topic all: " + message);
	}
	
	@KafkaListener(topics = "topicName")
	public void listenWithHeaders(
	  @Payload String message, 
	  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
	      System.out.println(
	        "Received Message: " + message
	        + "from partition: " + partition);
	}

}
