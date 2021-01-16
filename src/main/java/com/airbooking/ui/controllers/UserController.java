package com.airbooking.ui.controllers;

import com.airbooking.bl.services.UserService;
import com.airbooking.ui.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Iterable<UserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping
    public String updateUser() {
        return "this is a test put http response";
    }

    @DeleteMapping
    public String deleteUser() {
        return "this is a test delete http response";
    }
}
