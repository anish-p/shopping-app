package com.tw.shoppingapp.usecases.userregistration;

import com.tw.shoppingapp.entities.UserEntity;
import com.tw.shoppingapp.gateways.user.UserGateway;
import com.tw.shoppingapp.gateways.user.inmemory.User;
import com.tw.shoppingapp.usecases.UseCase;

public class UserRegistrationUseCase implements UseCase<UserRegistrationUseCaseRequest, UserRegistrationUseCaseResponse> {

    private UserGateway userGateway;

    public void setUserGateway(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public UserRegistrationUseCaseResponse execute(UserRegistrationUseCaseRequest useCaseRequest) {
        this.userGateway.save(getUserEntity(useCaseRequest));
        return new UserRegistrationUseCaseResponse(true);
    }

    private UserEntity getUserEntity(UserRegistrationUseCaseRequest useCaseRequest) {
        return new User.Builder()
                .name(useCaseRequest.name)
                .emailId(useCaseRequest.emailId)
                .username(useCaseRequest.username)
                .password(useCaseRequest.password)
                .address(useCaseRequest.address)
                .mobileNumber(useCaseRequest.mobileNumber)
                .type(useCaseRequest.type)
                .gender(useCaseRequest.gender)
                .dateOfBirth(useCaseRequest.dateOfBirth)
                .panNumber(useCaseRequest.panNumber)
                .expInYears(useCaseRequest.experienceInYears)
                .expInMonths(useCaseRequest.experienceInMonths)
                .build();
    }
}
