package com.vaghani.order_service.controller;

import com.vaghani.base_domains.dto.OrderDto;
import com.vaghani.base_domains.dto.OrderEventDto;
import com.vaghani.order_service.kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto) {
        orderDto.setId(UUID.randomUUID().toString());

        OrderEventDto orderEventDto = OrderEventDto.builder()
                .status("PENDING")
                .message("The order status is pending...")
                .order(orderDto)
                .build();

        orderProducer.sendMessage(orderEventDto);

        return ResponseEntity.ok("The order event has been successfully sent to the Kafka Broker!");
    }

}
