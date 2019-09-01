package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    private Group group = new Group(1L, "Test", new ArrayList<>());

    @Before
    public void prepareDatabase() {
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>());

        groupRepository.save(group);
        productRepository.save(product);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void create() {
        //Given
        Product product = new Product(2L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>());

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
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>());

        //When
        Product getProduct = productRepository.findById(1L).orElse(null);

        //Then
        assertTrue(new ReflectionEquals(product, "price").matches(getProduct));
        assertThat(new BigDecimal(100),  Matchers.comparesEqualTo(getProduct.getPrice()));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void update() {
        //Given
        Product product = new Product(1L, "TestTwo", "TestTwo", new BigDecimal(100), group, new ArrayList<>());

        //When
        productRepository.save(product);
        Product getProduct = productRepository.findById(1L).orElse(null);

        //Then
        assertTrue(new ReflectionEquals(product, "price").matches(getProduct));
        assertThat(new BigDecimal(100),  Matchers.comparesEqualTo(getProduct.getPrice()));
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