package com.tw.shoppingapp.usecases.userregistration;

import com.tw.shoppingapp.entities.UserEntity;
import com.tw.shoppingapp.gateways.user.inmemory.InMemoryUserGateway;
import com.tw.shoppingapp.gateways.user.inmemory.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
                .thenReturn(new User.Builder().name("Test name").build());
        final UserRegistrationUseCaseResponse userRegistrationUseCaseResponse = this.userRegistrationUseCase
                .execute(getValidUserRegistrationUseCaseRequest());
        assertThat(userRegistrationUseCaseResponse.isRegistrationSuccessful, is(true));
    }

    private UserRegistrationUseCaseRequest getValidUserRegistrationUseCaseRequest() {
        UserRegistrationUseCaseRequest useCaseRequest = new UserRegistrationUseCaseRequest();
        useCaseRequest.name = "Test name";
        useCaseRequest.emailId = "test@gmail.com";
        useCaseRequest.type = "buyer";
        return useCaseRequest;
    }

    @Test(expected = RuntimeException.class)
    public void givenGatewayFails_whenExecuted_ThrowRuntimeException() {
        this.userRegistrationUseCase
                .execute(getInvalidUserRegistrationUseCaseRequest());
    }

    private UserRegistrationUseCaseRequest getInvalidUserRegistrationUseCaseRequest() {
        UserRegistrationUseCaseRequest useCaseRequest = new UserRegistrationUseCaseRequest();
        useCaseRequest.name = null;
        return useCaseRequest;
    }
}