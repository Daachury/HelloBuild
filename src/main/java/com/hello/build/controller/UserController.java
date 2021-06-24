package com.hello.build.controller;

import com.hello.build.execption.UserNotFoundException;
import com.hello.build.model.User;
import com.hello.build.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/user/{id}")
    public User getfindUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/user")
    public List<User> getfindUsers() throws UserNotFoundException {
        List<User> users = userRepository.findAll();
        return users;
    }

}
