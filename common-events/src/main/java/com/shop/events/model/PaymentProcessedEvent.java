package com.shop.events.model;

public record PaymentProcessedEvent(String cardId, String userId, boolean success) {
}
