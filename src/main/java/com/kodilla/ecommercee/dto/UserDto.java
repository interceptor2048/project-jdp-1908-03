package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String username;
    private Long userKey;
    private String address;
    private String email;
    private String phoneNumber;
    private List<Order> orders = new ArrayList<>();
}
