package com.deepak.expensetrackerv1.service;

import com.deepak.expensetrackerv1.entities.User;
import com.deepak.expensetrackerv1.entities.UserModel;
import com.deepak.expensetrackerv1.exception.ItemAlreadyExistsException;
import com.deepak.expensetrackerv1.exception.ResourceNotFoundException;
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
    public UserModel createUser(UserModel user) {
        if(userRepo.existsByEmail(user.getEmail())) {
            throw new ItemAlreadyExistsException("User already exists with email: " + user.getEmail());
        }
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        userRepo.save(newUser);
        return user;
    }

    @Override
    public User readUser(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
}

