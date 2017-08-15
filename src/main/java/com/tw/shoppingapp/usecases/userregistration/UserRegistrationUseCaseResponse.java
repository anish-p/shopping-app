package com.tw.shoppingapp.usecases.userregistration;

import com.tw.shoppingapp.usecases.UseCaseResponse;

public class UserRegistrationUseCaseResponse implements UseCaseResponse {

    public boolean isRegistrationSuccessful;

    public UserRegistrationUseCaseResponse(boolean isRegistrationSuccessful) {
        this.isRegistrationSuccessful = isRegistrationSuccessful;
    }
}
