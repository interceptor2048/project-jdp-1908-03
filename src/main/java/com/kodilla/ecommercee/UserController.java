package com.kodilla.ecommercee;

import com.kodilla.ecommercee.controller.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="v1/user/", produces = "application/json")
@CrossOrigin("*")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping(value = "getUser")
    public User getUser(@RequestParam Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
    @GetMapping(value = "getUsers")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    @PostMapping(value = "addUser", consumes = "application/json")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
    @PutMapping(value = "updateUser", consumes = "application/json")
    public void updateUser(@RequestBody User user) {
        userRepository.save(user);
    }
    @DeleteMapping(value = "deleteUser")
    public void deleteUser(@RequestParam Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }
}
