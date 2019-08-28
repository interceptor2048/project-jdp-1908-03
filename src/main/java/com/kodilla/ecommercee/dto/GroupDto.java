package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class GroupDto {
    private Long id;
    private String name;
    private List<ProductDto> products;
}
