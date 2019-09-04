package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Group;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDtoTest {

    @Test
    public void getId() {
        //Given
        ProductDto productDto = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);

        //When
        Long id = productDto.getId();

        //Then
        assertEquals(1L, id, 0);
    }

    @Test
    public void getName() {
        //Given
        ProductDto productDto = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);

        //When
        String name = productDto.getName();

        //Then
        assertEquals("Test", name);
    }

    @Test
    public void getDescription() {
        //Given
        ProductDto productDto = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);

        //When
        String name = productDto.getName();

        //Then
        assertEquals("Test", name);
    }

    @Test
    public void getPrice() {
        //Given
        ProductDto productDto = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);

        //When
        BigDecimal price = productDto.getPrice();

        //Then
        assertThat(new BigDecimal(100),  Matchers.comparesEqualTo(price));
    }

    @Test
    public void getGroupId() {
        //Given
        ProductDto productDto = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);

        //When
        Long id = productDto.getGroupId();

        //Then
        assertEquals(1L, id, 0);
    }

    @Test
    public void setId() {
        //Given
        ProductDto productDto = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);

        //When
        productDto.setId(2L);
        Long id = productDto.getId();

        //Then
        assertEquals(2L, id, 0);
    }

    @Test
    public void setName() {
        //Given
        ProductDto productDto = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);

        //When
        productDto.setName("TestTwo");
        String name = productDto.getName();

        //Then
        assertEquals("TestTwo", name);
    }

    @Test
    public void setDescription() {
        //Given
        ProductDto productDto = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);

        //When
        productDto.setDescription("TestTwo");
        String name = productDto.getDescription();

        //Then
        assertEquals("TestTwo", name);
    }

    @Test
    public void setPrice() {
        //Given
        ProductDto productDto = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);

        //When
        productDto.setPrice(new BigDecimal(200));
        BigDecimal price = productDto.getPrice();

        //Then
        assertThat(new BigDecimal(200),  Matchers.comparesEqualTo(price));
    }

    @Test
    public void setGroupId() {
        //Given
        ProductDto productDto = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);

        //When
        productDto.setGroupId(2L);
        Long id = productDto.getGroupId();

        //Then
        assertEquals(2L, id, 0);
    }

    @Test
    public void equalsAndHashCode() {
        //Given
        ProductDto productDtoOne = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);
        ProductDto productDtoTwo = new ProductDto(1L, "Test", "Test", new BigDecimal(100), 1L);
        ProductDto productDtoThree = new ProductDto(2L, "Test", "Test", new BigDecimal(100), 1L);

        //Then
        assertTrue(new ReflectionEquals(productDtoOne, "price").matches(productDtoTwo));
        assertFalse(new ReflectionEquals(productDtoOne, "price").matches(productDtoThree));
    }
}