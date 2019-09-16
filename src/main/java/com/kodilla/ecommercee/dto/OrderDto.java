package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private Long orderId;
    private Status status;
    private LocalDate orderDate;
    private LocalDate sendDate;
    private LocalDate deliveredDate;
    private List<Product> products;
    private Long userId;
}