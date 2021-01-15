package com.airbooking.ui.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable Integer userId) {
        return "this is a test get http response" + " " + userId;
    }

    @PostMapping
    public String createUser() {
        return "this is a test post http response";
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
