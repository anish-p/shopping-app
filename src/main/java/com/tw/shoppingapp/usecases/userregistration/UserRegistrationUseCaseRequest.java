package com.tw.shoppingapp.usecases.userregistration;

import com.tw.shoppingapp.usecases.UseCaseRequest;

import java.util.Date;

public class UserRegistrationUseCaseRequest implements UseCaseRequest {

    public String name;
    public String emailId;
    public String username;
    public String password;
    public String address;
    public String mobileNumber;
    public String type;
    public String gender;
    public Date dateOfBirth;
    public String panNumber;
    public Integer experienceInYears;
    public Integer experienceInMonths;
}
