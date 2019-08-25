package com.kodilla.ecommercee.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GroupTest {

    @Test
    public void getId() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());

        //When
        Long id = group.getId();

        //Then
        assertEquals(1L, id, 0);
    }

    @Test
    public void getName() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());

        //When
        String name = group.getName();

        //Then
        assertEquals("Test", name);
    }

    @Test
    public void getProducts() {
        //Given
        List<Product> products = new ArrayList<>();

        products.add(new Product());
        products.add(new Product());
        products.add(new Product());


        Group group = new Group(1L, "Test", products);

        //When
        int countProducts = group.getProducts().size();

        //Then
        assertEquals(3, countProducts);
    }

    @Test
    public void setId() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());

        //When
        group.setId(2L);
        Long id = group.getId();

        //Then
        assertEquals(2L, id, 0);
    }

    @Test
    public void setName() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());

        //When
        group.setName("TestTwo");
        String name = group.getName();

        //Then
        assertEquals("TestTwo", name);
    }

    @Test
    public void setProducts() {
        //Given
        List<Product> products = new ArrayList<>();

        products.add(new Product());
        products.add(new Product());
        products.add(new Product());


        Group group = new Group(1L, "Test", products);

        //When
        products.remove(0);
        group.setProducts(products);
        int countProducts = group.getProducts().size();

        //Then
        assertEquals(2, countProducts);
    }

    @Test
    public void testEqualsAndHashcode() {
        //Given
        Group groupOne = new Group(1L, "Test", new ArrayList<>());
        Group groupTwo = new Group(1L, "Test", new ArrayList<>());
        Group groupThree = new Group(2L, "Test", new ArrayList<>());

        //Then
        assertEquals(groupOne, groupTwo);
        assertNotEquals(groupOne, groupThree);
    }
}