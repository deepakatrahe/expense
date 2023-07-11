package com.deepak.expensetrackerv1.entities;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UserModel {
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Email is required")
    @Email
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    private Long age =0L;
}
