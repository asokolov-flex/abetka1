package com.shop.events.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class AbstractOrderEvent {
    private String userId;
    private String cardId;
}
