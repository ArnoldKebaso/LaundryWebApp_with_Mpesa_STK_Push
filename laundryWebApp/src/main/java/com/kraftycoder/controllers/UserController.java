package com.kraftycoder.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kraftycoder.model.User;
import com.kraftycoder.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService user;

    @GetMapping("/users")
    public List<User> home() {
        return user.getUsers();
    }

    @PostMapping("/user")
    public void add() {

    }

    @GetMapping("user/{id}")
    public Optional getUsers(@PathVariable int id) {
        return user.getUser(id);
    }
}
