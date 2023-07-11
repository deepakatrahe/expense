package com.deepak.expensetrackerv1.service;

import com.deepak.expensetrackerv1.entities.User;
import com.deepak.expensetrackerv1.entities.UserModel;
import com.deepak.expensetrackerv1.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(UserModel user) {
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        return userRepo.save(newUser);
    }
}

