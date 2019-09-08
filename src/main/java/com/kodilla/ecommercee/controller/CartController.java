package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "v1/cart/")
@CrossOrigin("*")

public class CartController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(value = "createNewCart", consumes = APPLICATION_JSON_VALUE)
    public void createNewCart(@RequestBody CartDto cartDto) {
    }
    @GetMapping(value = "getProductFromCart")
    public List<Product> getProductFromCart(@RequestParam("cartId") Long cartId) {
        return new ArrayList<> ();
    }
    @PostMapping(value = "addProductToCart", consumes = APPLICATION_JSON_VALUE)
    public void addProductToCart(@RequestParam ("cartId") Long cartId, @RequestParam("productId") Long productId) {
    }
    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCard(@RequestParam ("cartId") Long cartId, @RequestParam("productId") Long productId) { }
    
    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestParam ("cartId") Long cartId) {
    }
}




