package com.abdelaziz26.kafkademo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic Topic1() {
        return TopicBuilder.name("Topic1").partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic Topic2() {
        return TopicBuilder.name("Topic2").partitions(1).replicas(1).build();
    }
}
