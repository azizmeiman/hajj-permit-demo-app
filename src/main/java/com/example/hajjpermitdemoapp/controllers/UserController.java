package com.example.hajjpermitdemoapp.controllers;


import com.example.hajjpermitdemoapp.entities.User;
import com.example.hajjpermitdemoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/user")
    public Page<User> getUser (Pageable pageable){
        return userService.getUser(pageable);
    }

    @PostMapping("/user")
    public User createUser (@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/user")
    public void deleteUser (){
        userService.deleteUser();
    }



}
