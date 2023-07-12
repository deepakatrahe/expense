package com.deepak.expensetrackerv1.controller;

import com.deepak.expensetrackerv1.entities.LoginModel;
import com.deepak.expensetrackerv1.entities.UserModel;
import com.deepak.expensetrackerv1.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.deepak.expensetrackerv1.utils.ValidationUtils.checkValidationError;

@RestController
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Pong", org.springframework.http.HttpStatus.OK);
    }

    @PostMapping ("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody LoginModel loginModel) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserModel user, final BindingResult bindingResult) {
        checkValidationError(bindingResult);
        return new ResponseEntity<>(userService.createUser(user), org.springframework.http.HttpStatus.CREATED);
    }
}
