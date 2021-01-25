package com.example.demo.kafka;

import java.util.concurrent.TimeUnit;

import com.example.demo.messages.Messages;
import com.example.demo.sql.Model.MessagesTable;
import com.example.demo.sql.Repo.MessageRepository;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

@RestController
@Service
public class KafkaConsumer {

    public boolean sendMessage = true;

    @Autowired
    MessageRepository repository;
    
    @Autowired
    private KafkaTemplate<String, Messages> kafkaTemplate;

    @KafkaListener(topics = "microservice1", groupId = "group1", containerFactory = "kafkaListenerFactory")
    public void consumerJson(Messages message) {
        System.out.println("Consumed Message: " + message.getMessage());
        String s1 = message.getMessage();
        String s2 = "start";
        if(s1.equals(s2)){ //Reactivate the loop in case it has been stopped.
            System.out.println("Setting Send message = true in microservice1");
            sendMessage = true;
        } 
        repository.save(new MessagesTable(message.getMessage()));

        System.out.println("Added message to the database");

        if (sendMessage) { //To check if the loop has been broken
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            kafkaTemplate.send("microservice2", new Messages(0, "Message from Microservice1"));
        }
        
    }

    @RequestMapping("/stop") //start is set in KafkaController.java File
    public String setSendMessage(){
        sendMessage = false;
        return "Stopped ping pong!";
    }

    @RequestMapping("/consumer") //Redirected request to set sendMessage to true which activates the loop
    public String updateSendMessage(){
        sendMessage = true;
        kafkaTemplate.send("microservice2", new Messages(0, "start"));
        return "Started Ping Pong!";
    }
}
