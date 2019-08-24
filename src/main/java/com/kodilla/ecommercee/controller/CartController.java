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
    @GetMapping(value = "getCarts")
    public List<CartDto> getCarts() {
        return cartMapper.mapToCartDtoList(cartService.getCarts());
    }
    @GetMapping(value = "getCart")
    public CartDto getCart(@RequestParam Long cartId) throws CartNotFoundException {
        Cart cart = cartService.getCart(id).orElseThrow(CartNotFoundException::new);
        return cartMapper.mapToCartDto(card);
    }
    @PostMapping(value = "saveCart",consumes = "application/json")
    public void saveCart(@RequestBody CartDto cartDto) {
        cartService.saveCart(cartMapper.mapToCart(cartDto));
    }
    @PutMapping(value = "updateCart",consumes = "application/json")
    public void updateCart(@RequestBody CartDto cartDto){
        cartService.updateCart(cartMapper.mapToCart(cartDto));
    }
    @DeleteMapping(value = "deleteCart")
    public void deleteCart(@RequestParam Long cartId) throws CartNotFoundException  {
        Cart cart = cartService.getCart(id).orElseThrow(ProductNotFoundException::new);
        CartService.deleteCart(cart);
    }
}
