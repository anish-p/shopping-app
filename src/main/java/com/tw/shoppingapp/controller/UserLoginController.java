package com.tw.shoppingapp.controller;

import com.tw.shoppingapp.gateways.user.inmemory.User;
import com.tw.shoppingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserLoginController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean Login(@RequestBody User user){
        System.out.println("sadfjasd" + user.getUsername() + user.getPassword());
        if(userService.getUser(user.getUsername(), user.getPassword())!=null)
            return true;
        return false;
    }

    @GetMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
