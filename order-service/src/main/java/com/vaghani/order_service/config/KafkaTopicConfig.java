package com.vaghani.order_service.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfig {

    @Value("${topicName}")
    private String topicName;

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name(topicName)
                .build();
    }

}
