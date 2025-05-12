package com.shop.billing.infrastructure.kafka;

import com.shop.events.model.OrderCreatedEvent;
import com.shop.events.model.OrderItem;
import com.shop.events.model.PaymentProcessedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedListener {

    private final PaymentProducer paymentProducer;

    @KafkaListener(topics = "order.created", groupId = "billing-service", containerFactory = "kafkaListenerContainerFactory")
    public void handleOrderCreated(OrderCreatedEvent event) {

        String userId = event.getUserId();

        String orderId = event.getCardId();

        List<OrderItem> items = event.getItems();

        log.info("Processing payment for order: {}", orderId);

        var payment = new PaymentProcessedEvent(orderId, userId, true);

        paymentProducer.send(payment);
    }
}
