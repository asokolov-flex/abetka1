package com.shop.events.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRejectedEvent extends AbstractOrderEvent{
    private String reason;

    public OrderRejectedEvent(String cardId, String userId, String reason) {

    }
}
