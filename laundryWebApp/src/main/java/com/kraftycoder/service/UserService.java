package com.kraftycoder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kraftycoder.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void addUser(UserService user) {

    }

    public List getUsers() {
        return userRepo.findAll();
    }

    public Optional getUser(int id) {
        return userRepo.findById(id);

    }
}
