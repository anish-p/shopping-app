package com.tw.shoppingapp.service;

import com.tw.shoppingapp.gateways.user.inmemory.User;
import com.tw.shoppingapp.gateways.user.inmemory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}