package com.shop.services;

import com.shop.events.model.OrderCreatedEvent;
import com.shop.events.model.OrderItem;
import com.shop.events.model.OrderRejectedEvent;
import com.shop.events.model.OrderReservedEvent;
import com.shop.infrastructure.kafka.WarehouseEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WarehouseService {

    private final WarehouseEventPublisher publisher;

    public void processOrder(OrderCreatedEvent event) {
        boolean allInStock = checkStock(event.getItems());

        if (allInStock) {
            publisher.publishOrderReserved(new OrderReservedEvent(
                event.getCardId(), event.getUserId(), event.getItems()
            ));
        } else {
            publisher.publishOrderRejected(new OrderRejectedEvent(
                event.getCardId(), event.getUserId(), "Some items are out of stock"
            ));
        }
    }

    private boolean checkStock(List<OrderItem> items) {
        return true;
    }
}
