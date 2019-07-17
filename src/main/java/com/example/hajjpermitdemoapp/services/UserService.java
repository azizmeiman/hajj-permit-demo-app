package com.example.hajjpermitdemoapp.services;


import com.example.hajjpermitdemoapp.entities.User;
import com.example.hajjpermitdemoapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService  {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User createUser(User user){
        user.setVerified(false);
        return userRepository.save(user);
    }

    @Transactional
    public Page<User> getUser(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @Transactional
    public void deleteUser(){
        userRepository.deleteAll();
    }

    @Transactional
    public User updateUser(User user){ return userRepository.save(user);}




}
