package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import org.hamcrest.Matchers;
import org.junit.Before;
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
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Before
    public void prepareDatabase() {
        Group group = new Group(1L, "Test", new ArrayList<>());

        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>(), new ArrayList<>());

        groupRepository.save(group);
        productRepository.save(product);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void create() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());
        Product product = new Product(2L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>(), new ArrayList<>());

        //When
        productRepository.save(product);
        int count = productRepository.findAll().size();

        //Then
        assertEquals(2, count);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void read() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>(), new ArrayList<>());

        //When
        Product getProduct = productRepository.findById(1L).orElse(null);

        //Then
        assertEquals(product.getId(), getProduct.getId());
        assertEquals(product.getName(), getProduct.getName());
        assertEquals(product.getDescription(), getProduct.getDescription());
        assertThat(new BigDecimal(100),  Matchers.comparesEqualTo(getProduct.getPrice()));
        assertEquals(product.getGroup().getId(), getProduct.getGroup().getId());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void update() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());
        Product product = new Product(1L, "TestTwo", "TestTwo", new BigDecimal(100), group, new ArrayList<>(), new ArrayList<>());

        //When
        productRepository.save(product);
        Product getProduct = productRepository.findById(1L).orElse(null);

        //Then
        assertEquals(product.getId(), getProduct.getId());
        assertEquals(product.getName(), getProduct.getName());
        assertEquals(product.getDescription(), getProduct.getDescription());
        assertThat(new BigDecimal(100),  Matchers.comparesEqualTo(getProduct.getPrice()));
        assertEquals(product.getGroup().getId(), getProduct.getGroup().getId());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void delete() {
        //When
        productRepository.deleteById(1L);
        Product product = productRepository.findById(1L).orElse(null);

        //Then
        assertNull(product);
    }
}