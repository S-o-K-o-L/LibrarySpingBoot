package com.example.library.controller;

import com.example.library.domain.entity.User;
import com.example.library.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUser() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User User) {
        return userService.saveUser(User);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User User, @PathVariable Long id) {
        return userService.updateUser(id, User);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
