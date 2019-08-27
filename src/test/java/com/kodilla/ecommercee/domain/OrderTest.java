package com.kodilla.ecommercee.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    public static final String NAME = "Test name for order";

    @Test
    public void testGetName() {
        //Given
        Order order = new Order(NAME);

        //When
        String name = order.getName();

        //Then
        assertEquals("Test name for order", name);
    }

    @Test
    public void testSetName() {
        //Given
        Order order = new Order(NAME);

        //When
       order.setName("New test name");
       String name = order.getName();

       //Then
        assertEquals("New test name", name);
    }
}
