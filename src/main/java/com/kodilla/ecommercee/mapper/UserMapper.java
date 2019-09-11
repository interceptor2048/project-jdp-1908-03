package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getUserKey(),
                userDto.getAddress(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getOrders());
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getUserKey(),
                user.getAddress(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getOrders());
    }

    public List<UserDto> mapToUserDtoList(List<User> userList) {
        return userList.stream()
                .map(u -> new UserDto(
                        u.getId(),
                        u.getUsername(),
                        u.getUserKey(),
                        u.getAddress(),
                        u.getEmail(),
                        u.getPhoneNumber(),
                        u.getOrders()))
                .collect(Collectors.toList());
    }
}
