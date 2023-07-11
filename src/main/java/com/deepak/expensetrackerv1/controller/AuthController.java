package com.deepak.expensetrackerv1.controller;

import com.deepak.expensetrackerv1.entities.UserModel;
import com.deepak.expensetrackerv1.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.deepak.expensetrackerv1.utils.ValidationUtils.checkValidationError;

@RestController
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return new ResponseEntity<>("Login successful", org.springframework.http.HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserModel user, final BindingResult bindingResult) {
        checkValidationError(bindingResult);
        return new ResponseEntity<>(userService.createUser(user), org.springframework.http.HttpStatus.CREATED);
    }
}
