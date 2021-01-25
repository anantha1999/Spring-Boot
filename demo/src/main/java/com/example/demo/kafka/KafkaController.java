package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.messages.Messages;

@RestController
public class KafkaController {

    // private boolean stop = true;
    // int id = 0;
    

    @RequestMapping("/")
    public String homePage() {
        return "You are in the home page";
    }

    @Autowired
    private KafkaTemplate<String, Messages> kafkaTemplate;

    @RequestMapping("/start") //Redirect the request to KafkaConsumer to activate the loop
    public String sendMessage(HttpServletResponse response) throws IOException {
        
        
        // kafkaTemplate.send("microservice2", new Messages(0, "start"));
         System.out.println("REDIRECTINGGGG");
         response.sendRedirect("/consumer");
        return "Redirected";
    }
    
    
}
