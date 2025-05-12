package com.shop.cart.domain.model;

import java.util.UUID;

public record CartItem(UUID productId, int quantity) {
}
