package com.kodilla.ecommercee.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CartTest {

    @Test
    public void testGetId() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);

        //When
        Long id = cart.getId();

        //Then
        assertEquals(1L, id, 0);
    }

    @Test
    public void testGetName() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);

        //When
        String name = cart.getName();

        //Then
        assertEquals("name", name);
    }

    @Test
    public void testGetPrice() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);

        //When
        BigDecimal price = cart.getPrice();

        //Then
        assertEquals(new BigDecimal(100), price);
    }

    @Test
    public void testGetQuantity() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);

        //When
        int quantity = cart.getQuantity();

        //Then
        assertEquals(100, quantity);
    }

    @Test
    public void testGetUser() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);

        //When
        User user2 = cart.getUser();

        //Then
        assertEquals(user, user2);
    }

    @Test
    public void testGetProducts() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);

        //When
        List products = cart.getProducts();

        //Then
        assertEquals(new ArrayList<>(), products);
    }

    @Test
    public void testSetId() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);

        //When
        cart.setId(2L);
        Long id = cart.getId();

        //Then
        assertEquals(2L, id, 0);
    }

    @Test
    public void testSetName() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);

        //When
        cart.setName("name2");
        String name2 = cart.getName();

        //Then
        assertEquals("name2", name2);
    }

    @Test
    public void testSetPrice() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);

        //When
        cart.setPrice(new BigDecimal(200L));
        BigDecimal price = cart.getPrice();

        //Then
        assertEquals(new BigDecimal(200L) ,price);
    }

    @Test
    public void testSetQuantity() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);

        //When
        cart.setQuantity(200);
        int quantity = cart.getQuantity();

        //Then
        assertEquals(200, quantity);
    }

    @Test
    public void testSetUser() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);
        User user2 = new User(2L, "test", 1L, "adress", "mail", "number", new ArrayList<>());

        //When
        cart.setUser(user2);
        User userGet = cart.getUser();

        //Then
        assertEquals(user2, userGet);
    }

    @Test
    public void testSetProducts() {
        //Given
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);
        List<Product> products = new ArrayList<>();
        products.add(new Product());

        //When
        cart.setProducts(products);
        int countProducts = cart.getProducts().size();

        //Then
        assertEquals(1, countProducts);
    }
}
