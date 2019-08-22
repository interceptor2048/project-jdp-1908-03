package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.controller.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "v1/product", produces = "application/json")
public class ProductController {
    private ProductService productService;
    private ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam Long id) throws ProductNotFoundException {
        Product product = productService.getProduct(id).orElseThrow(ProductNotFoundException::new);
        return productMapper.mapToProductDto(product);
    }

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productService.getProducts());
    }

    @PostMapping(value = "addProduct", consumes = "application/json")
    public void addProduct(@RequestBody ProductDto productDto) throws GroupNotFoundException {
        productService.saveProduct(productMapper.mapToProduct(productDto));
    }

    @PutMapping(value = "updateProduct", consumes = "application/json")
    public void updateProduct(@RequestBody ProductDto productDto) throws GroupNotFoundException {
        productService.saveProduct(productMapper.mapToProduct(productDto));
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long id) throws ProductNotFoundException {
        Product product = productService.getProduct(id).orElseThrow(ProductNotFoundException::new);
        productService.deleteProduct(product);
    }
}
