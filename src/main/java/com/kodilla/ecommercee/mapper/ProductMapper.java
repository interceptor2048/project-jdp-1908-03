package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.controller.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    private GroupService groupService;

    public ProductMapper(GroupService groupService) {
        this.groupService = groupService;
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getGroup().getId()
        );
    }

    public Product mapToProduct(final ProductDto productDto) throws GroupNotFoundException {
        Group group = groupService.getGroup(productDto.getGroupId()).orElseThrow(GroupNotFoundException::new);

        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                group,
                // TODO - add order when order service will be created
                new ArrayList<>(),
                new ArrayList<>()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> products) throws GroupNotFoundException {
        List<Product> productsList = new ArrayList<>();

        for(ProductDto product : products) {
            productsList.add(mapToProduct(product));
        }

        return productsList;
    }
}
