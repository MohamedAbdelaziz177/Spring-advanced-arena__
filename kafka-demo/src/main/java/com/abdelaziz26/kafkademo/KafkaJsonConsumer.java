package com.abdelaziz26.kafkademo;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonConsumer {

    private final String groupId = "myGroup";

    private final static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @KafkaListener(groupId = groupId, topics = "jsonTopic")
    public void consumeFromJsonTopic(Product message) {
        logger.info("Consumed message {} from JsonTopic", message.toString());
    }
}
