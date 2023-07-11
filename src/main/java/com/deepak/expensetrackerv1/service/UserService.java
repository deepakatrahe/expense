package com.deepak.expensetrackerv1.service;

import com.deepak.expensetrackerv1.entities.User;
import com.deepak.expensetrackerv1.entities.UserModel;

public interface UserService {

    UserModel createUser(UserModel user);
    User readUser(Long id);
}
