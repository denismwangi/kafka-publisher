package com.aver.publisher.controller;


import com.aver.publisher.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/**
 * author denis
 * 17/6/21
 */

@RestController
public class MessageConsumerController {

    User userFromTopic = null;

    List<String> messages = new ArrayList<>();


    /**
     * consume plain text
     * @return
     */
    @GetMapping("/consumeStringMsg")
    public List<String> consumeMsg(){
        return messages;
    }

    /**
     * consume json data
     * @return
     */
    @GetMapping("/consumeJsonMsg")
    public User consumeJson(){
        return userFromTopic;
    }

    /**
     * plain text listener
     * @param data
     * @return
     */
    @KafkaListener(groupId = "averdev", topics = "kafka-prod", containerFactory = "kafkaListenerContainerFactory")
    public List<String> getMessage(String data){
        messages.add(data);
        return  messages;

    }


    /**
     * json data listener
     * @param user
     * @return
     */
    @KafkaListener(groupId = "averdev-1", topics = "kafka-prod", containerFactory = "userKafkaListenerContainerFactory")
    public User getJsonMessage(User user){
        userFromTopic = user;
        return  userFromTopic;

    }


}
