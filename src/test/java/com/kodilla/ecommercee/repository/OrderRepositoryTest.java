package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;
    private static final String NAME = "test entity order name";

    @Test
    public void testSaveOrderEntity() {
        //Given
        Order order = new Order(NAME);

        //When
        Order createOrder = orderRepository.save(order);

        //Then
        assertEquals(order, createOrder);
    }

    @Test
    public void testUpdateOrderEntity() {
        //Given
        Order order = new Order(NAME);

        //When
        order.setName("New test name");
        Order orderUpdated = orderRepository.save(order);

        //Then
        assertEquals("New test name", orderUpdated.getName());
    }
}
