package com.tw.shoppingapp.controller;

import com.tw.shoppingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;

public class UserLoginController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean Login(String username, String password){
        if(userService.getUser(username, password)!=null)
            return true;
        return false;
    }
}
