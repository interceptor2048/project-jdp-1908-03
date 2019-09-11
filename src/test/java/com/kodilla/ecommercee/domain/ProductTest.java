package com.kodilla.ecommercee.domain;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductTest {

    @Test
    public void getId() {
        //Given
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), new ArrayList<>(), new ArrayList<>());

        //When
        Long id = product.getId();

        //Then
        assertEquals(1L, id, 0);
    }

    @Test
    public void getName() {
        //Given
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), new ArrayList<>(), new ArrayList<>());

        //When
        String name = product.getName();

        //Then
        assertEquals("Test", name);
    }

    @Test
    public void getDescription() {
        //Given
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), new ArrayList<>(), new ArrayList<>());

        //When
        String description = product.getDescription();

        //Then
        assertEquals("Test", description);
    }

    @Test
    public void getPrice() {
        //Given
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), new ArrayList<>(), new ArrayList<>());

        //When
        BigDecimal price = product.getPrice();

        //Then
        assertThat(new BigDecimal(100),  Matchers.comparesEqualTo(price));
    }

    @Test
    public void getGroup() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>(), new ArrayList<>());

        //When
        Group getGroup = product.getGroup();

        //Then
        assertEquals(group, getGroup);
    }

    @Test
    public void getOrders() {
        //Given
        List<Order> orders = new ArrayList<>();

        orders.add(new Order());
        orders.add(new Order());
        orders.add(new Order());

        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), orders, new ArrayList<>());

        //When
        int countOrders = product.getOrders().size();

        //Then
        assertEquals(3, countOrders);
    }

    @Test
    public void setId() {
        //Given
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), new ArrayList<>(), new ArrayList<>());

        //When
        product.setId(2L);
        Long id = product.getId();

        //Then
        assertEquals(2L, id, 0);
    }

    @Test
    public void setName() {
        //Given
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), new ArrayList<>(), new ArrayList<>());

        //When
        product.setName("TestTwo");
        String name = product.getName();

        //Then
        assertEquals("TestTwo", name);
    }

    @Test
    public void setDescription() {
        //Given
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), new ArrayList<>(), new ArrayList<>());

        //When
        product.setDescription("TestTwo");
        String description = product.getDescription();

        //Then
        assertEquals("TestTwo", description);
    }

    @Test
    public void setPrice() {
        //Given
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), new ArrayList<>(), new ArrayList<>());

        //When
        product.setPrice(new BigDecimal(200));
        BigDecimal price = product.getPrice();

        //Then
        assertThat(new BigDecimal(200),  Matchers.comparesEqualTo(price));
    }

    @Test
    public void setGroup() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), group, new ArrayList<>(), new ArrayList<>());

        //When
        group.setId(2L);
        product.setGroup(group);
        Group getGroup = product.getGroup();

        //Then
        assertEquals(group, getGroup);
    }

    @Test
    public void setOrders() {
        //Given
        List<Order> orders = new ArrayList<>();

        orders.add(new Order());
        orders.add(new Order());
        orders.add(new Order());

        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), orders, new ArrayList<>());

        //When
        orders.remove(0);
        product.setOrders(orders);
        int countOrders = product.getOrders().size();

        //Then
        assertEquals(2, countOrders);
    }

    @Test
    public void equalsAndHashCode() {
        //Given
        Product productOne = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), new ArrayList<>(), new ArrayList<>());
        Product productTwo = new Product(1L, "Test", "Test", new BigDecimal(100), new Group(), new ArrayList<>(), new ArrayList<>());
        Product productThree = new Product(2L, "Test", "Test", new BigDecimal(100), new Group(), new ArrayList<>(), new ArrayList<>());

        //Then
        assertTrue(new ReflectionEquals(productOne, "price").matches(productTwo));
        assertFalse(new ReflectionEquals(productOne, "price").matches(productThree));
    }
}