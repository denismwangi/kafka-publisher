package com.aver.publisher.controller;

import com.aver.publisher.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProducerController {

    @Autowired
    private KafkaTemplate<String, Object> template;

    private String topic = "kafka-prod";


    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name){

        template.send(topic,"hello" +name+ "kafka is awesome");
        return "Data published";
    }

    @GetMapping("/publishJson")
    public String publishMessage(){
        User user = new User(1, "denis","4567890");
        template.send(topic, user);

        return "Json data published";
    }

}
