package com.deepak.expensetrackerv1.service;

import com.deepak.expensetrackerv1.entities.User;
import com.deepak.expensetrackerv1.entities.UserModel;

public interface UserService {

    User createUser(UserModel user);
}
