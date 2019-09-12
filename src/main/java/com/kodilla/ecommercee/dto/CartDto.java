package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Long group;
    private List<Product> products;
    private User user;
}
