package com.example1.demo1.kafka;

import java.util.concurrent.TimeUnit;

import com.example1.demo1.messages.Messages;
import com.example1.demo1.sql.Model.MessagesTable;
import com.example1.demo1.sql.Repo.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class KafkaConsumer {

    public boolean sendMessage = true;


    @Autowired
    MessageRepository repository;

    @Autowired
    private KafkaTemplate<String, Messages> kafkaTemplate;

    @KafkaListener(topics = "microservice2", groupId = "group2", containerFactory = "kafkaListenerFactory2")
    public void consumerJson(Messages message) {
        System.out.println("Consumed Message: " + message.getMessage());
        String s1 = message.getMessage();
        String s2 = "start";
        if(s1.equals(s2)){ // Reactivate the loop incase it has been stopped
            System.out.println("Setting Send message = true in microservice2");
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
            kafkaTemplate.send("microservice1", new Messages(0, "Message from Microservice2"));
        }
        
    }

    @RequestMapping("/stop") //start is set in KafkaProducer.java file
    public String setSendMessage(){
        sendMessage = false;
        
        return "Stopped ping pong!";
    }

    @RequestMapping("/consumer") //Redirected request to set sendMessage to true which activates the loop
    public String updateSendMessage(){
        sendMessage = true;
        System.out.println("Redirected!!!");
        kafkaTemplate.send("microservice1", new Messages(0, "start"));
        return "Started Ping Pong!";
    }
}
