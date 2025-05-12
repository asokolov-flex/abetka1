package com.shop.cart.infrastructure;


import com.shop.cart.infrastructure.kafka.OrderEventPublisher;
import com.shop.cart.domain.model.Cart;
import com.shop.cart.domain.model.CartItem;
import com.shop.events.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartUseCaseImpl implements CartUseCase {

    private final InMemoryCartRepository cartRepository;
    private final OrderEventPublisher eventPublisher;

    public CartUseCaseImpl(InMemoryCartRepository cartRepository, OrderEventPublisher eventPublisher) {
        this.cartRepository = cartRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void addItem(UUID userId, UUID productId, int quantity) {
        Cart cart = cartRepository.getOrCreateCart(userId);
        cart.addItem(productId, quantity);
        cartRepository.save(cart);
    }

    @Override
    public void removeItem(UUID userId, UUID productId) {
        Cart cart = cartRepository.getOrCreateCart(userId);
        cart.removeItem(productId);
        cartRepository.save(cart);
    }

    @Override
    public Cart getCart(UUID userId) {
        return cartRepository.getOrCreateCart(userId);
    }

    @Override
    public void checkout(UUID userId) {
        Cart cart = cartRepository.getOrCreateCart(userId);

        List<OrderItem> items = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            items.add(new OrderItem(item.productId().toString(), item.quantity()));
        }

        eventPublisher.publishOrderCreated(userId, cart.getCartId(), items);
    }
}
