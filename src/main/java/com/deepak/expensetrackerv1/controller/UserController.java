package com.deepak.expensetrackerv1.controller;

import com.deepak.expensetrackerv1.entities.User;
import com.deepak.expensetrackerv1.entities.UserModel;
import com.deepak.expensetrackerv1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody UserModel user) {
        return new ResponseEntity<>(userService.createUser(user), org.springframework.http.HttpStatus.CREATED);
    }
}
