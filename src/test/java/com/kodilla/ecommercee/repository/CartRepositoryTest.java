package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.User;
import org.junit.Assert;
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

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CartRepositoryTest {
    @Autowired
    private CartRepository cartRepository;

    @Before
    public void prepareDatabase() {
        User user = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user);
        cartRepository.save(cart);
    }

    /*@Test
    @Transactional
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testFindById() {
        //Given
        User user2 = new User(2L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart2 = new Cart(2L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user2);

        //When
        Cart findCart = cartRepository.findById(2L).orElse(null);
        int size = cartRepository.findAll().size();

        //Then
        Assert.assertEquals(cart2, findCart);
        assertEquals(2, size);
    }*/

    @Test
    @Transactional
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testUpdate() {
        //Given
        User user2 = new User(1L, "test", 1L, "adress", "mail", "number", new ArrayList<>());
        Cart cart = new Cart(1L, "name", new BigDecimal(100L), 100, 1L, new ArrayList<>(), user2);

        //When
        cartRepository.save(cart);
        Cart updatedCart = cartRepository.findById(1L).orElse(null);

        //Then
        assertEquals(cart, updatedCart);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testDelete() {
        //When
        cartRepository.deleteById(1L);
        Cart deleteCart = cartRepository.findById(1L).orElse(null);

        //Then
        assertNull(deleteCart);
    }
}
