package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.kodilla.ecommercee.domain.Status.OPEN;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testCreate() {
        //Given
        User user = new User(null, "TestName1", 20L, "TestAddress1", "TestEmail1", "TestPhoneNumber1", new ArrayList<>());
        Order order = new Order(null, OPEN, LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 2),
                LocalDate.of(2019, 1, 3), new ArrayList<>(), user);
        Group group = new Group(null, "TestGroup1", new ArrayList<>());
        Product product = new Product(null, "TestProduct1", "Test1", new BigDecimal(100), group, new ArrayList<>());
        user.getOrders().add(order);
        order.getProducts().add(product);
        group.getProducts().add(product);
        product.getOrders().add(order);

        //When
        userRepository.save(user);
        int numberOfItems = userRepository.findAll().size();

        //Then
        assertEquals(1, numberOfItems);
    }

    @Test
    @Transactional
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testRead() {
        //Given
        User user = new User(null, "TestName1", 20L, "TestAddress1", "TestEmail1", "TestPhoneNumber1", new ArrayList<>());
        Order order = new Order(null, OPEN, LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 2),
                LocalDate.of(2019, 1, 3), new ArrayList<>(), user);
        Group group = new Group(null, "TestGroup1", new ArrayList<>());
        Product product = new Product(null, "TestProduct1", "Test1", new BigDecimal(100), group, new ArrayList<>());
        user.getOrders().add(order);
        order.getProducts().add(product);
        group.getProducts().add(product);
        product.getOrders().add(order);
        userRepository.save(user);

        //When
        User readUser = userRepository.findById(1L).orElse(null);

        //Then
        assertEquals(user.getId(), readUser.getId());
        assertEquals(user.getUsername(), readUser.getUsername());
        assertEquals(user.getUserKey(), readUser.getUserKey());
        assertEquals(user.getAddress(), readUser.getAddress());
        assertEquals(user.getEmail(), readUser.getEmail());
        assertEquals(user.getPhoneNumber(), readUser.getPhoneNumber());
        assertEquals(1,readUser.getOrders().size());

        assertEquals(user.getOrders().get(0).getUser().getUsername(), readUser.getOrders().get(0).getUser().getUsername());
        assertEquals(user.getOrders().get(0).getProducts().get(0).getName(), readUser.getOrders().get(0).getProducts().get(0).getName());
    }

    @Test
    @Transactional
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testUpdate() {
        //Given
        User user = new User(null, "TestName1", 20L, "TestAddress1", "TestEmail1", "TestPhoneNumber1", new ArrayList<>());
        Order order = new Order(null, OPEN, LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 2),
                LocalDate.of(2019, 1, 3), new ArrayList<>(), user);
        Group group = new Group(null, "TestGroup1", new ArrayList<>());
        Product product = new Product(null, "TestProduct1", "Test1", new BigDecimal(100), group, new ArrayList<>());
        user.getOrders().add(order);
        order.getProducts().add(product);
        group.getProducts().add(product);
        product.getOrders().add(order);
        userRepository.save(user);

        //When
        user.setUsername("TestName2");
        userRepository.save(user);
        User updatedUser = userRepository.findById(1L).orElse(null);

        //Then
        assertEquals(user.getUsername(), updatedUser.getUsername());
    }

    @Test
    @Transactional
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testDelete() {
        //Given
        User user = new User(null, "TestName1", 20L, "TestAddress1", "TestEmail1", "TestPhoneNumber1", new ArrayList<>());
        Order order = new Order(null, OPEN, LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 2),
                LocalDate.of(2019, 1, 3), new ArrayList<>(), user);
        Group group = new Group(null, "TestGroup1", new ArrayList<>());
        Product product = new Product(null, "TestProduct1", "Test1", new BigDecimal(100), group, new ArrayList<>());
        user.getOrders().add(order);
        order.getProducts().add(product);
        group.getProducts().add(product);
        product.getOrders().add(order);
        userRepository.save(user);

        //When
        userRepository.deleteById(1L);
        User deletedUser = userRepository.findById(1L).orElse(null);

        //Then
        assertEquals(null, deletedUser);
    }
}
