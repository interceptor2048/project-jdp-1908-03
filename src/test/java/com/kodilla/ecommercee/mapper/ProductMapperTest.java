package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.controller.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupMapper groupMapper;

    @Test
    public void mapToProductDto() {
        //Given
        Group group = new Group(1L, "Test", new ArrayList<>());
        Product product = new Product(1L, "Test", "Test", new BigDecimal(100), group);

        //When
        ProductDto productDto = productMapper.mapToProductDto(product);

        //Then
        assertEquals(1L, productDto.getGroupId(), 0);
        assertEquals("Test", productDto.getName());
        assertEquals("Test", productDto.getDescription());
        assertEquals(new BigDecimal(100), productDto.getPrice());
    }

    @Test
    public void mapToProduct() throws GroupNotFoundException {
        //Given
        GroupDto groupDto = new GroupDto(1L, "Test", new ArrayList<>());
        ProductDto productDto = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);

        groupService.saveGroup(groupMapper.mapToGroup(groupDto));

        //When
        Product product = productMapper.mapToProduct(productDto);

        //Then
        assertEquals(1L, product.getId(), 0);
        assertEquals("Test", product.getName());
        assertEquals("Test", product.getDescription());
        assertEquals(new BigDecimal(100), product.getPrice());
    }

    @Test
    public void mapToProductDtoList() {
        //Given
        List<Product> products = new ArrayList<>();

        Group group = new Group(1L, "Test", new ArrayList<>());

        Product productOne = new Product(1L, "Test", "Test", new BigDecimal(100), group);
        Product productTwo = new Product(2L, "Test", "Test", new BigDecimal(100), group);
        Product productThree = new Product(3L, "Test", "Test", new BigDecimal(100), group);

        products.add(productOne);
        products.add(productTwo);
        products.add(productThree);

        //When
        List<ProductDto> productsDto = productMapper.mapToProductDtoList(products);

        //Then
        assertEquals(3, productsDto.size());

    }

    @Test
    public void mapToProductList() throws GroupNotFoundException {
        //Given
        List<ProductDto> productsDto = new ArrayList<>();

        GroupDto groupDto = new GroupDto(1L, "Test", new ArrayList<>());

        ProductDto productDtoOne = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);
        ProductDto productDtoTwo = new ProductDto(2L, "Test", "Test", new BigDecimal(100), 1L);
        ProductDto productDtoThree = new ProductDto(3L, "Test", "Test", new BigDecimal(100), 1L);

        groupService.saveGroup(groupMapper.mapToGroup(groupDto));

        productsDto.add(productDtoOne);
        productsDto.add(productDtoTwo);
        productsDto.add(productDtoThree);

        //When
        List<Product> products = productMapper.mapToProductList(productsDto);

        //Then
        assertEquals(3, products.size());
    }
}