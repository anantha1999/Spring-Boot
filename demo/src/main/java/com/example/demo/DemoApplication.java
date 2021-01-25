package com.example.demo;



import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication //This tells springboot that this is the starting point of our application
public class DemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// @KafkaListener(topics = "microservice1", groupId = "group-id")
	// public void listen(String message) {
	//    System.out.println("Received Messasge in group - group-id: " + message);
	// }
	
}
