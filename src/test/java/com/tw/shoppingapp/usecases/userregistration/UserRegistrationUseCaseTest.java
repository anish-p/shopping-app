package com.tw.shoppingapp.usecases.userregistration;

import com.tw.shoppingapp.entities.UserEntity;
import com.tw.shoppingapp.gateways.user.inmemory.InMemoryUserGateway;
import com.tw.shoppingapp.gateways.user.inmemory.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationUseCaseTest {

    @Mock
    private InMemoryUserGateway inMemoryUserGateway;

    @InjectMocks
    private UserRegistrationUseCase userRegistrationUseCase;

    @Test
    public void givenValidUseCaseRequest_whenExecuted_ReturnSuccessfulResponse() {
        when(this.inMemoryUserGateway
                .save(any(UserEntity.class)))
                .thenReturn(new User.Builder().build());
        final UserRegistrationUseCaseResponse userRegistrationUseCaseResponse = this.userRegistrationUseCase
                .execute(new UserRegistrationUseCaseRequest());
        assertThat(userRegistrationUseCaseResponse.isRegistrationSuccessful, is(true));
    }

}