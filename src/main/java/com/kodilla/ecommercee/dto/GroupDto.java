package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Dawid Nogacz on 22.08.2019
 */
@AllArgsConstructor
@Data
public class GroupDto {
    private Long id;
    private String name;
    private List<ProductDto> products;
}
