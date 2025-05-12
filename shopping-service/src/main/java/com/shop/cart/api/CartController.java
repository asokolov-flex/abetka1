package com.shop.cart.api;

import com.shop.cart.domain.model.Cart;
import com.shop.cart.infrastructure.CartUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartUseCase cartUseCase;

    public CartController(CartUseCase cartUseCase) {
        this.cartUseCase = cartUseCase;
    }

    @PostMapping("/{userId}/items")
    public void addItem(@PathVariable String userId, @RequestBody Map<String, Object> request) {
        UUID productId = UUID.fromString((String) request.get("productId"));
        int quantity = (int) request.get("quantity");
        cartUseCase.addItem(UUID.fromString(userId), productId, quantity);
    }

    @PostMapping("/{userId}/checkout")
    public void checkout(@PathVariable UUID userId) {
        cartUseCase.checkout(userId);
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable UUID userId) {
        return cartUseCase.getCart(userId);
    }
}
