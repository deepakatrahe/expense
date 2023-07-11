package com.deepak.expensetrackerv1.controller;

import com.deepak.expensetrackerv1.entities.User;
import com.deepak.expensetrackerv1.entities.UserModel;
import com.deepak.expensetrackerv1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.deepak.expensetrackerv1.utils.ValidationUtils.checkValidationError;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> readUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.readUser(id), org.springframework.http.HttpStatus.OK);
    }
}
