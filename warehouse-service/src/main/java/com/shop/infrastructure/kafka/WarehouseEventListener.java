package com.shop.infrastructure.kafka;

import com.shop.events.model.OrderCreatedEvent;
import com.shop.domain.services.WarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class WarehouseEventListener {

    private final WarehouseService warehouseService;

    @KafkaListener(topics = "order.created", groupId = "warehouse-service")
    public void handleOrderCreated(OrderCreatedEvent event) {
        log.info("Received OrderCreatedEvent: {}", event);
        warehouseService.processOrder(event);
    }
}
