package com.shop.billing.infrastructure.kafka;

import com.shop.events.model.PaymentProcessedEvent;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentProducer {

    private final KafkaTemplate<String, PaymentProcessedEvent> kafkaTemplate;

    public void send(PaymentProcessedEvent event) {
        kafkaTemplate.send("payment.processed", event);
    }
}
