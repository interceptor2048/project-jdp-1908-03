package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "v1/product", produces = "application/json")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "getProduct")
    public Product getProduct(@RequestParam Long id) throws ProductNotFoundException {
        return productService.getProduct(id).orElseThrow(ProductNotFoundException::new);
    }

    @GetMapping(value = "getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping(value = "addProduct", consumes = "application/json")
    public void addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PutMapping(value = "updateProduct", consumes = "application/json")
    public void updateProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long id) throws ProductNotFoundException {
        Product product = productService.getProduct(id).orElseThrow(ProductNotFoundException::new);
        productService.deleteProduct(product);
    }
}
