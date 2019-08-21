package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "v1/product", produces = "application/json")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "getProduct")
    public Product getProduct(@RequestParam Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @GetMapping(value = "getProducts")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping(value = "addProduct", consumes = "application/json")
    public void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @PutMapping(value = "updateProduct", consumes = "application/json")
    public void updateProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long id) throws ProductNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        productRepository.delete(product);
    }
}
