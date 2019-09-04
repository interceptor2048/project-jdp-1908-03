package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private Long id;
    //private String status;
    private LocalDate orderDate;
    private LocalDate sendDate;
    private LocalDate deliveredDate;
    private List<Product> products;
}