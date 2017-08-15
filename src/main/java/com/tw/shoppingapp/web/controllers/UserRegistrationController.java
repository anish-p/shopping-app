package com.tw.shoppingapp.web.controllers;

import com.tw.shoppingapp.usecases.userregistration.UserRegistrationUseCase;
import com.tw.shoppingapp.usecases.userregistration.UserRegistrationUseCaseRequest;
import com.tw.shoppingapp.usecases.userregistration.UserRegistrationUseCaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "user")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationUseCase userRegistrationUseCase;

    @ApiOperation(value = "Responsible for registering a new user",
            notes = "Registers only a single customer at a time", response = UserRegistrationUseCaseResponse.class)
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public UserRegistrationUseCaseResponse register(
            @RequestBody final UserRegistrationUseCaseRequest userRegistrationUseCaseRequest) {
        return this.userRegistrationUseCase.execute(userRegistrationUseCaseRequest);
    }
}
