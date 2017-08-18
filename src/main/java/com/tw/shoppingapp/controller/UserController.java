package com.tw.shoppingapp.controller;

import com.tw.shoppingapp.entity.User;
import com.tw.shoppingapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Api(value = "users")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Responsible for registering a new user",
            notes = "Registers only a single customer at a time", response = User.class)
    @PostMapping(value = "/users", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public User register(@RequestBody User user) {
        return userService.createUser(user);
    }


    @GetMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
