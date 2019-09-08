package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    public void createNewCart() {}
    
    @GetMapping(value = "getProductFromCart")
    public List<Product> getProductFromCart(@RequestParam("productId") Long productId) {
        return new ArrayList<> ();
    }
    @PostMapping(value = "addProductToCart", consumes = APPLICATION_JSON_VALUE)
    public ProductDto addProductToCart(@RequestBody ProductDto productDto) {
        return new ProductDto (2L, "example product2", "description", new BigDecimal (100), (long) 2);
    }
    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCard(@RequestParam ("cartId") Long cartId, @RequestParam("productId") Long productId) { }
    
    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestBody ProductDto productDto) {
        return new OrderDto ();
    }
}




