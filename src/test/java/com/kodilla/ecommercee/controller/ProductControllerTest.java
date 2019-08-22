package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author Dawid Nogacz on 21.08.2019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void getProduct() {
        //Given
        Group group = new Group(1L, "Test", null);

        Product product = new Product(
                1L,
                "Test",
                "Description",
                new BigDecimal(100),
                group
        );

        groupRepository.save(group);
        productRepository.save(product);

        //When
        Optional<Product> findProduct = productRepository.findById(1L);

        //Then
        assertTrue(findProduct.isPresent());
    }

    @Test
    public void getProductEmpty() {
        //Given

        //When
        Optional<Product> findProduct = productRepository.findById(1L);

        //Then
        assertFalse(findProduct.isPresent());
    }
}