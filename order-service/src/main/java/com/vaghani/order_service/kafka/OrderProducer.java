package com.vaghani.order_service.kafka;

import com.vaghani.base_domains.dto.OrderEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {

    private final NewTopic topic;

    private final KafkaTemplate<String, OrderEventDto> kafkaTemplate;

    public void sendMessage(OrderEventDto orderEvent) {
        log.info("This is the event: {}", orderEvent);
        Message<OrderEventDto> message = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }


}
