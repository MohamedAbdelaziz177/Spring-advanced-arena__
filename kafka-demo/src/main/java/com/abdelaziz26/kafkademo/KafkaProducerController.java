package com.abdelaziz26.kafkademo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producer")
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<?> publish(@RequestParam String message, @RequestParam String topic)
    {
        kafkaProducer.publish(topic, message);
        return ResponseEntity.ok(message + " sent to topic: " + topic);
    }

    @PostMapping("/publish")
    public ResponseEntity<?> publish(@RequestBody Product product)
    {
        kafkaProducer.publishJson(product);
        return ResponseEntity.ok("Product sent to jsonTopic");
    }
}
