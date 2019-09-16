package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="v1/user/", produces = "application/json")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping(value = "getUser")
    public UserDto getUser(@RequestParam Long id) throws UserNotFoundException {
        return userMapper.mapToUserDto(userService.getUser(id).orElseThrow(UserNotFoundException::new));
    }

    @GetMapping(value = "getUsers")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(userService.getUsers());
    }

    @PostMapping(value = "addUser", consumes = "application/json")
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userDto)));
    }

    @PutMapping(value = "updateUser", consumes = "application/json")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userDto)));
    }

    @DeleteMapping(value = "deleteUser")
    public void deleteUser(@RequestParam Long id) throws UserNotFoundException {
        userService.getUser(id).orElseThrow(UserNotFoundException::new);
        userService.deleteUser(id);
    }
}
