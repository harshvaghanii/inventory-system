package com.vaghani.email_service.kafka;

import com.vaghani.base_domains.dto.OrderEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderConsumer {

    @KafkaListener(topics = "${topicName}", groupId = "${groupName}")
    public void consume(OrderEventDto orderEventDto) {
        log.info("This is the event consumed in Email Service: {}", orderEventDto);
        //TODO: Send an email to the customer
    }


}
