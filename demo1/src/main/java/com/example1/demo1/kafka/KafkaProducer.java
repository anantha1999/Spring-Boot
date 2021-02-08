package com.example1.demo1.kafka;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import com.example1.demo1.messages.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {

    // private boolean stop = true;

    KafkaConsumer consumer = new KafkaConsumer();
    // int id = 0;
    @RequestMapping("/")
    public String homePage(){
        return "You are in the home page";
    }

    @Autowired
   	private KafkaTemplate<String, Messages> kafkaTemplate;

    @Autowired
    private KafkaConsumer kafkaconsumer;

    @RequestMapping("/start")
    public String sendMessage(HttpServletResponse response) throws IOException {
        
        
        // kafkaTemplate.send("microservice2", new Messages(0, "start"));
        kafkaconsumer.sendMessage = true;
        System.out.println("Producer - Done setting sendMessage");
        kafkaTemplate.send("microservice1", new Messages(0, "start"));
        return "Started Ping Pong";
    }
    
       
       
}
