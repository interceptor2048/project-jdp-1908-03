package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void prepareDatabase() {
        Cart cart = new Cart(1L, "testName", new BigDecimal(100), 1, 1L, new ArrayList<>(), new User());
        cartRepository.save(cart);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void create() {
        //Given
        Cart cart = new Cart(2L, "testName", new BigDecimal(100), 1, 1L, new ArrayList<>(), new User());

        //When
        cartRepository.save(cart);
        int count = cartRepository.findAll().size();

        //Then
        assertEquals(2, count);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Transactional
    public void read() {
        //Given
        User user = new User(1l, "test", 1l, "test", "test", "test", new ArrayList<>());
        Cart cart = new Cart(1L, "testName", new BigDecimal(100), 1, 1L, new ArrayList<>(), user);

        //When
        userRepository.save(user);
        cartRepository.save(cart);
        Cart readCart = cartRepository.findById(1L).orElse(null);

        //Then
        assertEquals(cart, readCart);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Transactional
    public void update() {
        //Given
        User user = new User(1l, "test", 1l, "test", "test", "test", new ArrayList<>());
        Cart cart = new Cart(1L, "testName 2", new BigDecimal(100), 1, 1L, new ArrayList<>(), user);

        //When
        cartRepository.save(cart);
        Cart updateCart = cartRepository.findById(1L).orElse(null);

        //Then
        assertEquals(cart, updateCart);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void delete() {
        //When
        cartRepository.deleteById(1L);
        Cart deleteCart = cartRepository.findById(1L).orElse(null);

        //Then
        assertNull(deleteCart);
    }
}
