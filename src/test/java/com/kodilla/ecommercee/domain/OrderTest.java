package com.kodilla.ecommercee.domain;

import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static com.kodilla.ecommercee.domain.Status.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OrderTest {

    @Test
    public void testGetId() {
        //Given
        Order order = new Order(1L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        Long id = order.getId();

        //Then
        assertEquals(1L, id, 0);
    }

    @Test
    public void testSetId() {
        //Given
        Order order = new Order(1L, OPEN,  LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        order.setId(2L);
        Long id = order.getId();

        //Then
        assertEquals(2L, id, 0);
    }

    @Test
    public void testGetStatus() {
        //Given
        Order order = new Order(1L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        Status status = order.getStatus();

        //Then
        assertEquals(OPEN, status);
    }

    @Test
    public void testSetStatus() {
        //Given
        Order order = new Order(1L, OPEN,  LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        order.setStatus(IN_PROGRESS);
        Status status = order.getStatus();

        //Then
        assertEquals(IN_PROGRESS, status);
    }

    @Test
    public void testGetOrderDate() {
        //Given
        Order order = new Order(1L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        LocalDate expected = LocalDate.of(2019, 8, 28);
        LocalDate localDate = order.getOrderDate();

        //Then
        assertEquals(expected, localDate);
    }

    @Test
    public void testSetOrderDate() {
        //Given
        Order order = new Order(1L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        LocalDate expected = LocalDate.of(2019, 8, 29);
        order.setOrderDate(LocalDate.of(2019, 8, 29));
        LocalDate localDate = order.getOrderDate();

        //Then
        assertEquals(expected, localDate);
    }

    @Test
    public void testGetSendDate() {
        //Given
        Order order = new Order(1L, IN_PROGRESS, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        LocalDate expected = LocalDate.of(2019, 8, 29);
        LocalDate localDate = order.getSendDate();

        //Then
        assertEquals(expected, localDate);
    }

    @Test
    public void testSetSendDate() {
        //Given
        Order order = new Order(1L, IN_PROGRESS, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        LocalDate expected = LocalDate.of(2019, 8, 30);
        order.setSendDate(LocalDate.of(2019, 8, 30));
        LocalDate localDate = order.getSendDate();

        //Then
        assertEquals(expected, localDate);
    }

    @Test
    public void testGetDeliveredDate() {
        //Given
        Order order = new Order(1L, CLOSED, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        LocalDate expected = LocalDate.of(2019, 8, 30);
        LocalDate localDate = order.getDeliveredDate();

        //Then
        assertEquals(expected, localDate);
    }

    @Test
    public void testSetDeliveredDate() {
        //Given
        Order order = new Order(1L, CLOSED, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        //When
        LocalDate expected = LocalDate.of(2019, 8, 31);
        order.setDeliveredDate(LocalDate.of(2019, 8, 31));
        LocalDate localDate = order.getDeliveredDate();

        //Then
        assertEquals(expected, localDate);
    }

    @Test
    public void testSetProducts() {
        //Given
        Order order = new Order(1L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());

        List<Product> products = new ArrayList<>();

        products.add(new Product());
        products.add(new Product());


        //When
        order.setProducts(products);
        int countProducts = order.getProducts().size();

        //Then
        assertEquals(2, countProducts);
    }

    @Test
    public void testEqualsAndHashcode() {
        //Given
        Order orderOne = new Order(1L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());
        Order orderTwo = new Order(1L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());
        Order orderThree = new Order(2L, OPEN, LocalDate.of(2019, 8, 28), LocalDate.of(2019, 8, 29), LocalDate.of(2019, 8, 30), new ArrayList<>());


        //Then
        assertEquals(orderOne, orderTwo);
        assertNotEquals(orderOne, orderThree);
    }
}
