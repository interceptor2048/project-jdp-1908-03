package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private GroupService groupService;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getProduct() throws ProductNotFoundException {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>());

        groupService.saveGroup(group);
        productService.saveProduct(product);

        //When
        Product getProduct = productService.getProduct(1L).orElseThrow(ProductNotFoundException::new);

        //Then
        assertEquals(product.getId(), getProduct.getId());
        assertEquals(product.getName(), getProduct.getName());
        assertEquals(product.getDescription(), getProduct.getDescription());
        assertThat(new BigDecimal(100),  Matchers.comparesEqualTo(getProduct.getPrice()));
        assertEquals(product.getGroup().getId(), getProduct.getGroup().getId());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getProducts() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());

        Product productOne = new Product(1L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>());
        Product productTwo = new Product(2L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>());
        Product productThree = new Product(3L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>());

        groupService.saveGroup(group);
        productService.saveProduct(productOne);
        productService.saveProduct(productTwo);
        productService.saveProduct(productThree);

        //When
        List<Product> products = productService.getProducts();

        //Then
        assertEquals(3, products.size());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void saveProduct() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>());

        groupService.saveGroup(group);
        //When
        Product productSave = productService.saveProduct(product);

        //Then
        assertEquals(product, productSave);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deleteProduct() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());
        Product product = new Product(null, "Test", "Test", new BigDecimal(100), group, new ArrayList<>());

        groupService.saveGroup(group);
        productService.saveProduct(product);

        //When
        productService.deleteProduct(1L);
        int countProducts = productService.getProducts().size();

        //Then
        assertEquals(0, countProducts);
    }
}