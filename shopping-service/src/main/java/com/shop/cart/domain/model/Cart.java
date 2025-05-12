package com.shop.cart.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    private final UUID cartId;
    private final UUID userId;
    private final List<CartItem> items = new ArrayList<>();

    public Cart(UUID cartId, UUID userId) {
        this.cartId = cartId;
        this.userId = userId;
    }

    public void addItem(UUID productId, int quantity) {
        items.add(new CartItem(productId, quantity));
    }

    public void removeItem(UUID productId) {
        items.removeIf(item -> item.productId().equals(productId));
    }

    public UUID getCartId() { return cartId; }
    public UUID getUserId() { return userId; }
    public List<CartItem> getItems() { return items; }
}
