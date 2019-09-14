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
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Before
    public void prepareDatabase() {
        User user = new User(1L, "TestUsername", 100L, "TestAdres", "testEmail", "TestphoneNumber", new ArrayList<>());
        Cart cart = new Cart(1L, "TestName", new BigDecimal(100), 100, 100L, new ArrayList<>(), user);
        cartRepository.save(cart);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testSaveAndFindAll() {
        //Given
        User user2 = new User(2L, "TestUsername", 100L, "TestAdres", "testEmail", "TestphoneNumber", new ArrayList<>());
        Cart cart2 = new Cart(2L, "TestName", new BigDecimal(100), 100, 100L, new ArrayList<>(), user2);

        //When
        cartRepository.save(cart2);
        int size = cartRepository.findAll().size();

        //Then
        Assert.assertEquals(2, size);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void read() {
        //Given
        User user2 = new User(2L, "TestUsername", 100L, "TestAdres", "testEmail", "TestphoneNumber", new ArrayList<>());
        Cart cart2 = new Cart(3L, "TestName", new BigDecimal(100), 100, 100L, new ArrayList<>(), user2);

        //When
        cartRepository.save(cart2);
        Cart cartFound2 = cartRepository.findById(3L).orElse(null);

        //Then
        Assert.assertEquals(2, cartRepository.findAll().size());
        Assert.assertEquals(cart2, cartFound2);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void delete() {
        //When
        cartRepository.deleteById(1L);
        Cart deletedCart = cartRepository.findById(1L).orElse(null);

        //Then
        Assert.assertNull(deletedCart);
    }
}
