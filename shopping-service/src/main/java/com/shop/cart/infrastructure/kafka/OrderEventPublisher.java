package com.shop.cart.infrastructure.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.events.model.OrderCreatedEvent;
import com.shop.events.model.OrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class OrderEventPublisher {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    private final ObjectMapper objectMapper;

    private final Logger logger = LoggerFactory.getLogger(OrderEventPublisher.class);

    public OrderEventPublisher(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }
    public void publishOrderCreated(UUID userId, UUID cartId, List<OrderItem> items) {
        try {
            OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();

            orderCreatedEvent.setEventType("OrderCreated");
            orderCreatedEvent.setUserId(String.valueOf(userId));
            orderCreatedEvent.setCardId(String.valueOf(cartId));
            orderCreatedEvent.setItems(items);

            kafkaTemplate.send("order.created", orderCreatedEvent);
        } catch (Exception ex) {
            logger.error("Publish order created event failed", ex);
        }
    }
}
