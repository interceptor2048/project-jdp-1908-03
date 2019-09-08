package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroupDto {
    private Long id;
    private String name;
    private List<ProductDto> products;
}