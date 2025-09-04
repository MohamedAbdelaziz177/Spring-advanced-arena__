package com.abdelaziz26.kafkademo;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    public void publish(String topic, String message) {

        logger.info(topic + ": " + message);
        kafkaTemplate.send(topic, message);
    }

    public void publishJson(Product product) {

        logger.info(product.toString());

        Message<Product> message = MessageBuilder
                .withPayload(product)
                .setHeader(KafkaHeaders.TOPIC, "jsonTopic")
                .build();

        kafkaTemplate.send(message);
    }
}
