package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import static com.kodilla.ecommercee.domain.Status.OPEN;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testCreateOrderEntity() {
        //Given
        Order order = new Order(1L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        orderRepository.save(order);
        int createdOrder = orderRepository.findAll().size();

        //Then
        assertEquals(1, createdOrder);
    }

    @Test
    @Transactional
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testReadOrderEntity() {
        //Given
        Order order = new Order(1L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        orderRepository.save(order);
        Order readOrder = orderRepository.findById(1L).orElse(null);

        //Then
        assertEquals(order, readOrder);
    }

    @Test
    @Transactional
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testUpdateOrderEntity() {
        //Given
        Order order = new Order(1L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());
        orderRepository.save(order);

        //When
        Order updatedDateOrder = new Order(1L, OPEN, LocalDate.of(2019, 7, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());
        orderRepository.save(updatedDateOrder);
        Order updateOrder = orderRepository.findById(1L).orElse(null);

        //Then
        assertEquals(updatedDateOrder, updateOrder);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testDeleteOrderEntity() {
        //Given
        Order order = new Order(1L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());
        orderRepository.save(order);

        //When
        orderRepository.deleteById(1L);
        Order deletedRepository = orderRepository.findById(1L).orElse(null);
        //Then
        assertEquals(null, deletedRepository);
    }
}

