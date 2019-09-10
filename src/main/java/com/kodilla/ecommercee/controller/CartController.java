package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "v1/cart/")
@CrossOrigin("*")

public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "createNewCart", consumes = APPLICATION_JSON_VALUE)
    public void createNewCart(@RequestBody CartDto cartDto) {
        cartService.addCart(cartMapper.mapToCart(cartDto));
    }

    @GetMapping(value = "getProductsFromCart")
    public CartDto getProductsFromCart(@RequestParam("cartId") Long cartId) {
        return cartMapper.mapToCartDto(cartService.getCart(cartId).orElseThrow(CartNotFoundException::new));
    }

    @PostMapping(value = "addProductToCart", consumes = APPLICATION_JSON_VALUE)
    public void addProductToCart(@RequestParam ("cartId") Long cartId, @RequestParam("productId") Long productId) {
        Cart cart = cartService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        Product product = cartService.findProduct(productId).orElseThrow(CartNotFoundException::new);
        cart.getProducts().add(product);
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCard(@RequestParam ("cartId") Long cartId, @RequestParam("productId") Long productId) {
        Cart cart = cartService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        Product product = cartService.findProduct(productId).orElseThrow(CartNotFoundException::new);
        cart.getProducts().remove(product);
    }
    
    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestParam ("order") Order order) {
        return orderMapper.mapToOrderDto(orderService.saveOrder(order));
    }
}




