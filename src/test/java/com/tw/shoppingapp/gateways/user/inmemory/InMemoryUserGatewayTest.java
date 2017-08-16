package com.tw.shoppingapp.gateways.user.inmemory;

import com.tw.shoppingapp.entities.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.ConstraintViolationException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InMemoryUserGatewayTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private InMemoryUserGateway userGateway;

    @Test
    public void givenBuyerRegistrationRequest_whenExecuted_ThenReturnSuccessfullResponse() {
        when(this.userRepository.save(any(User.class))).thenReturn((User) getValidBuyer());
        UserEntity buyer = this.userGateway.save(getValidBuyer());
        assertThat(buyer, is(notNullValue()));
        assertThat(buyer.getName(), is("dummy-user"));
        assertThat(buyer.getAddress(), is("dummy address"));
        assertThat(buyer.getMobileNumber(), is("+91-1234567890"));
    }

    @Test(expected = ConstraintViolationException.class)
    public void givenDuplicateBuyerRegistrationRequest_whenExecuted_ThenThrowException() {
        when(this.userRepository.save(any(User.class))).thenThrow(ConstraintViolationException.class);
        this.userGateway.save(new User());
    }

    private UserEntity getValidBuyer() {
        return new User.Builder()
                .name("dummy-user")
                .address("dummy address")
                .mobileNumber("+91-1234567890")
                .type("Buyer")
                .build();
    }
}
