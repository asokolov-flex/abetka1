package com.shop.cart.infrastructure;

import com.shop.cart.domain.model.Cart;

import java.util.UUID;

public interface CartUseCase {
    void addItem(UUID userId, UUID productId, int quantity);
    void removeItem(UUID userId, UUID productId);
    Cart getCart(UUID userId);
    void checkout(UUID userId);
}
