package com.shop.infrastructure.kafka;

import com.shop.events.model.AbstractOrderEvent;
import com.shop.events.model.OrderRejectedEvent;
import com.shop.events.model.OrderReservedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WarehouseEventPublisher {

    private final KafkaTemplate<String, AbstractOrderEvent> kafkaTemplate;

    public void publishOrderReserved(OrderReservedEvent event) {
        kafkaTemplate.send("order.reserved", event.getCardId(), event);
    }

    public void publishOrderRejected(OrderRejectedEvent event) {
        kafkaTemplate.send("order.rejected", event.getCardId(), event);
    }
}
