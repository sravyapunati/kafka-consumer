package com.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private static final Logger log = LogManager.getLogger(ConsumerService.class);
    public ConsumerService(){
        log.info("Application started kafka");
    }

   // ConcurrentKafkaListenerContainerFactory<String,String> consumerTemplate = new ConcurrentKafkaListenerContainerFactory<>();
    @KafkaListener(topics = "evt_enterprise", groupId = "evt-grp-1")
    public void listen(ConsumerRecord<String,String> message) {
        System.out.println("messa"+message);
        log.info("Message consumed: {}", message);
        log.debug(message);
    }
}
