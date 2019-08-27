package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exeptions.CartNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/cart/",produces = "application/json")
@CrossOrigin("*")

public class CartController {

    private CartService cartService;
    private CartMapper cartMapper;

    public CartController(CartService cartService, CartMapper cartMapper) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
    }
    @PostMapping(value = "createNewCart",consumes = "application/json")
    public void createNewCart(@RequestBody CartDto cartDto) {
        cartService.createNewCart(cartMapper.mapToCart(cartDto));
    }
    @GetMapping(value = "getItemsFromCart")
    public CartDto getItemsFromCart(@RequestParam long cartId) throws CartNotFoundException {
        return cartMapper.mapToCartDto(cartService.getCart(cartId).orElseThrow(CartNotFoundException::new));
    }
    @PostMapping(value = "addItemToCart",consumes = "application/json")
    public CartDto addItemToCart(@RequestParam long cartId, @RequestBody ProductItem productItem) throws CartNotFoundException{
        return cartMapper.mapToCartDto(cartService.addItemToCard(cartId, productItem));
    }
    @DeleteMapping(value = "removeItemFromCart")
    public CartDto removeItemFromCard(@RequestParam long cartId, @RequestParam long itemId) throws CartNotFoundException{
        return cartMapper.mapToCartDto(cartService.removeItemFromCard(cartId, itemId));
    }
    @PostMapping(value = "createOrder", consumes = "application/json")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return orderMapper.mapToOrderDto(orderService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }
}
