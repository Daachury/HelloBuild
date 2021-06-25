package com.hello.build.controller;

import com.hello.build.execption.UserNotFoundException;
import com.hello.build.model.User;
import com.hello.build.repository.UserRepository;
import com.hello.build.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @Autowired
    private UserService userService;


    @GetMapping("/user/{id}")
    public User getfindUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/user")
    public List<User> getfindUsers() throws UserNotFoundException {
        List<User> users = userRepository.findAll();
        return users;
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user) {
      //  User usuario = userService.getUserService(user.getId());
        userRepository.save(user);
    }


}
