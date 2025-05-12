package com.shop.cart.infrastructure;

import com.shop.cart.domain.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryCartRepository {
    private final Map<UUID, Cart> carts = new ConcurrentHashMap<>();

    public Cart getOrCreateCart(UUID userId) {
        return carts.computeIfAbsent(userId, id -> new Cart(UUID.randomUUID(), id));
    }

    public void save(Cart cart) {
        carts.put(cart.getUserId(), cart);
    }
}
