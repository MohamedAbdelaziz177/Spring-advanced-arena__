package com.abdelaziz26.kafkademo;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer1 {

    private final String groupId = "myGroup";

    private final static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @KafkaListener(groupId = groupId, topics = "Topic1")
    public void consumeFromTopic1(String message) {
        logger.info("Consumed message {} from Topic1", message);
    }

    @KafkaListener(groupId = groupId, topics = "Topic2")
    public void consumeFromTopic2(String message) {
        logger.info("Consumed message {} from Topic2", message);
    }

}
