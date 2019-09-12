package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    @Autowired
    OrderService orderService;

    private Optional<Order> getOrder(Long id) {
        return orderService.getOrder(id);
    }

    public CartDto mapToCartDto(final Cart cart){
        return new CartDto(cart.getId(), cart.getName(), cart.getPrice(), cart.getQuantity(), cart.getGroup(), cart.getProducts(), cart.getUser());
    }

    public Cart mapToCart(final CartDto cartDto){
        return new Cart(cartDto.getId(), cartDto.getName(), cartDto.getPrice(), cartDto.getQuantity(), cartDto.getGroup(), cartDto.getProducts(), cartDto.getUser());
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList){
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
