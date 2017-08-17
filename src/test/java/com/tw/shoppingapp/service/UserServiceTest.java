package com.tw.shoppingapp.service;

import com.tw.shoppingapp.gateways.user.inmemory.User;
import com.tw.shoppingapp.gateways.user.inmemory.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.Mockito.when;

public class UserServiceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository mockUserRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFindUserBasedOnUsernameAndPassword(){
        //Given
        User mockUser = new User("Someone", "someone@fsd.com", "123", "mypass", "myaddress", "8902342", "sometype", "M", new Date(), "myPan", 2, 2);
        when(mockUserRepository.findByUsernameAndPassword("123", "mypass")).thenReturn(mockUser);

        //When & then
        Assert.assertEquals("123", userService.getUser("123", "mypass").getUsername());
    }
}
