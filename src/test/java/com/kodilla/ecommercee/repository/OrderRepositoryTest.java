package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
<<<<<<< HEAD
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import java.util.ArrayList;
import static com.kodilla.ecommercee.domain.Status.OPEN;
=======
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

>>>>>>> b10fef649581f82a855b411eaf00d0d987ff230f
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;
<<<<<<< HEAD

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
=======
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
>>>>>>> b10fef649581f82a855b411eaf00d0d987ff230f
