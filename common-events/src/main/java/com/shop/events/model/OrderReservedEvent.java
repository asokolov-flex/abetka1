package com.shop.events.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderReservedEvent extends AbstractOrderEvent{
    private List<OrderItem> items;

    public OrderReservedEvent(String cardId, String userId, List<OrderItem> items) {

    }
}

