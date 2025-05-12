package com.shop.events.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class OrderCreatedEvent extends AbstractOrderEvent {
    private String eventType;
    private List<OrderItem> items;

}
