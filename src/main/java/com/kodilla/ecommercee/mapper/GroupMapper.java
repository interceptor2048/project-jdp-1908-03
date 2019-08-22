package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.controller.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dawid Nogacz on 22.08.2019
 */
@Component
public class GroupMapper {
    private ProductService productService;
    private ProductMapper productMapper;

    public GroupMapper(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    public GroupDto mapToGroupDto(final Group group) {
        return new GroupDto(
                group.getId(),
                group.getName(),
                group.getProducts().stream().map(productMapper::mapToProductDto).collect(Collectors.toList())
        );
    }

    public Group mapToGroup(final GroupDto groupDto) throws GroupNotFoundException {
        return new Group(
                groupDto.getId(),
                groupDto.getName(),
                productMapper.mapToProductList(groupDto.getProducts())
        );
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> groups) {
        return groups.stream()
                .map(this::mapToGroupDto)
                .collect(Collectors.toList());
    }
}
