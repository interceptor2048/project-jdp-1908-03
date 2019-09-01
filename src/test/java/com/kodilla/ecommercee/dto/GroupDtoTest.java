package com.kodilla.ecommercee.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GroupDtoTest {

    @Test
    public void getId() {
        //Given
        GroupDto groupDto = new GroupDto(1L, "Test", new ArrayList<>());

        //When
        Long id = groupDto.getId();

        //Then
        assertEquals(1L, id, 0);
    }

    @Test
    public void getName() {
        //Given
        GroupDto groupDto = new GroupDto(1L, "Test", new ArrayList<>());

        //When
        String name = groupDto.getName();

        //Then
        assertEquals("Test", name);
    }

    @Test
    public void getProducts() {
        //Given
        List<ProductDto> products = new ArrayList<>();

        products.add(new ProductDto());
        products.add(new ProductDto());
        products.add(new ProductDto());

        GroupDto groupDto = new GroupDto(1L, "Test", products);

        //When
        int countProducts = groupDto.getProducts().size();

        //Then
        assertEquals(3, countProducts);
    }

    @Test
    public void setId() {
        //Given
        GroupDto groupDto = new GroupDto(1L, "Test", new ArrayList<>());

        //When
        groupDto.setId(2L);
        Long id = groupDto.getId();

        //Then
        assertEquals(2L, id, 0);
    }

    @Test
    public void setName() {
        //Given
        GroupDto groupDto = new GroupDto(1L, "Test", new ArrayList<>());

        //When
        groupDto.setName("TestTwo");
        String name = groupDto.getName();

        //Then
        assertEquals("TestTwo", name);
    }

    @Test
    public void setProducts() {
        //Given
        List<ProductDto> products = new ArrayList<>();

        products.add(new ProductDto());
        products.add(new ProductDto());
        products.add(new ProductDto());

        GroupDto groupDto = new GroupDto(1L, "Test", products);

        //When
        products.remove(0);
        groupDto.setProducts(products);
        int countProducts = groupDto.getProducts().size();

        //Then
        assertEquals(2, countProducts);
    }

    @Test
    public void equals() {
        //Given
        GroupDto groupDtoOne = new GroupDto(1L, "Test", new ArrayList<>());
        GroupDto groupDtoTwo = new GroupDto(1L, "Test", new ArrayList<>());
        GroupDto groupDtoThree = new GroupDto(2L, "Test", new ArrayList<>());

        //Then
        assertEquals(groupDtoOne, groupDtoTwo);
        assertNotEquals(groupDtoOne, groupDtoThree);
    }
}