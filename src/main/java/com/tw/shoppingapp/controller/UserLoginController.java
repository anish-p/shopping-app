package com.tw.shoppingapp.controller;

import com.tw.shoppingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class UserLoginController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean Login(String username, String password){
        System.out.println("sadfjasd" + username + password);
        if(userService.getUser(username, password)!=null)
            return true;
        return false;
    }
}
